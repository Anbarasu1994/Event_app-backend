package com.paramporul.foundation.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.paramporul.foundation.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
	@Autowired
	private final FirebaseMessaging firebaseMessaging;

	public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
		this.firebaseMessaging = firebaseMessaging;
	}

	public String sendNotification(Note note, String token) throws FirebaseMessagingException {
		Notification notification = Notification.builder().setTitle(note.getSubject()).setBody(note.getContent())
				.setImage(note.getImage()).build();
		Message message = Message.builder().setToken(token).setNotification(notification).putAllData(note.getData())
				.build();
		return firebaseMessaging.send(message);
	}
}
