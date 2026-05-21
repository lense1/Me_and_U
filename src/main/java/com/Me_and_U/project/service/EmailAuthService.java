package com.Me_and_U.project.service;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.Me_and_U.project.EmailAutoConfiguration;

@Component
public class EmailAuthService {
	@Autowired
	private JavaMailSender mailSender;
	private EmailAutoConfiguration mailConfig;
	private int authNumber; 
	
	// 랜덤 난수 생성
	public void RandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	
	// 이메일 보낼 양식
	public String joinEmail(String email) {
		RandomNumber();
		String setFrom = System.getenv("SMTP_USERNAME");
		String toMail = email;
		// 이메일 제목
		String title = "회원 가입 인증 이메일 입니다.";
		// 이메일 내용
		String content = "Me & U를 방문해주셔서 감사합니다." + "<br><br>" + "인증번호는 " + authNumber + "입니다." + "<br>" + "해당 인증번호를 확인란에 기입하여 주세요.";
		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNumber);
	}
	
	public void mailSend(String setFrom, String toMail, String title, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
