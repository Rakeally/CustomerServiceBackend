package com.CallCenter.master.Controllers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.CallCenter.master.Entities.AppRole;
import com.CallCenter.master.Entities.AppUser;
import com.CallCenter.master.Objects.RegisterEmployee;
import com.CallCenter.master.Objects.ResetPasswordRequest;
import com.CallCenter.master.Repositories.AppRoleRepository;
import com.CallCenter.master.Repositories.AppUserRepository;
import com.CallCenter.master.Services.AccountServices;
import com.CallCenter.master.Services.AccountServicesImp;
import com.example.jpa.exception.ApiRequestException;

@RestController
@CrossOrigin(origins = "*")
public class AppUserController {

	@Autowired
   RestTemplate restTemplate = new RestTemplate(); 

	@Autowired
	private AppUserRepository appUserRepo;

	@Autowired
	private AccountServicesImp accountServiceImp;



	@Autowired
    private SpringTemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;
    @Autowired
	private AccountServices userService;
    
    @Autowired
    private AppRoleRepository appRoleRepository;

    
    @PostMapping("/signupAdmin")
    @Transactional
	public ResponseEntity<?> signUp(@RequestBody RegisterEmployee registerAdmin) throws MessagingException {
        if (appUserRepo.findByEmailIgnoreCase(registerAdmin.getEmail()) != null)
            throw new ApiRequestException("This user already exist, try again with a different email");
        else {
		String password= registerAdmin.getPassword();
		String repassword= registerAdmin.getConfirmPassword();
		if(!password.equals(repassword)) throw new RuntimeException("Password doesn't match");
		AppRole role = appRoleRepository.findByRole("ADMIN");
		System.out.println("role" + role);
		AppUser u = new AppUser();
		u.setUsername(registerAdmin.getEmail());
		u.setPassword(password);
		u.setEmail(registerAdmin.getEmail());
		u.setTel(registerAdmin.getTel());
		u.setRole(role);
		u.setToken(UUID.randomUUID().toString());
		u.setActive(true);
		accountServiceImp.saveUser(u);

		return new ResponseEntity<>("Account creation successful" , HttpStatus.ACCEPTED);
        }
				//return (u);
	}

    
	  @RequestMapping(value = "/reset", method = RequestMethod.POST)
		public ResponseEntity<?> setNewPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {

			// Find the user associated with the reset token
			Optional<AppUser> user = appUserRepo.findByToken(resetPasswordRequest.getToken());

			// This should always be non-null but we check just in case
			if (user.isPresent()) {
				
				AppUser resetUser = user.get(); 
	            
				// Set new password    
	            resetUser.setPassword(resetPasswordRequest.getPassword());
	            
				resetUser.setToken(null);
				resetUser.setActive(true);

				// Save user
				accountServiceImp.saveUser(resetUser);
				
				return new ResponseEntity<>("Password reset successfully", HttpStatus.OK );
			}
			else {
				return new ResponseEntity<>("Password reset failed", HttpStatus.BAD_REQUEST );
			}	

		}

	
		@GetMapping("/listUsers")
		public List<AppUser> listAllUsers(){
			return appUserRepo.findAll();
		}

		@GetMapping("/countUsers")
		public int countAllUsers(){
					 return appUserRepo.findAll().size();
					
				}
		
		
		  @GetMapping("/authenticate")
		  @ResponseStatus(HttpStatus.NO_CONTENT)
		  public void authenticate() {

		  }
		  	  
		  
			@PostMapping("/forgotPass/{email}")
			public ResponseEntity<?> ForgotPassword(@PathVariable(name="email") String userEmail ) throws MessagingException {

				// Lookup user in database by e-mail
				Optional<AppUser> optional = Optional.of(appUserRepo.findByEmailIgnoreCase(userEmail));
				

				if (!optional.isPresent()) {
					return new ResponseEntity<>( "email not found", HttpStatus.NOT_FOUND);
				} 
		
				 else {
						
						// Generate random 36-character string token for reset password 
						AppUser user = optional.get();
						user.setToken(UUID.randomUUID().toString());

						// Save token to database
						userService.saveUser(user);

						
						String link = "https://localhost:8080"+ "/reset-password/" + user.getToken();

						MimeMessage mimeMessage = javaMailSender.createMimeMessage();
						
						MimeMessageHelper helper =  new MimeMessageHelper(mimeMessage,
								MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				                StandardCharsets.UTF_8.name());
						
						Context context = new Context();
				        context.setVariable("link", link);
				        context.setVariable("user", user.getUsername());
				        String html = templateEngine.process("resetPassword", context);
						SimpleMailMessage mail = new SimpleMailMessage();
				        helper.setTo(user.getEmail());
				        helper.setSubject("Passwork Reset demand!");
				        helper.setFrom("kjappcoder@gmail.com");
				        helper.setText(html, true);
						
					    javaMailSender.send(mimeMessage);

						return new ResponseEntity<>("A password reset link has been sent to " + userEmail, HttpStatus.OK);
					}

				}

		
		}