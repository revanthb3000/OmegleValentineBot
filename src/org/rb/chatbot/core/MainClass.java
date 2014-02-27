package org.rb.chatbot.core;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * This is the glue that sticks the webhandler functions together.
 * 
 * @author RB
 * 
 */
public class MainClass {

	/**
	 * A starting point for the code. Nothing much in here. Move along
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Boolean isOwnerPresent = true;
		ArrayList<String> topics = new ArrayList<String>(Arrays.asList("love","valentine", "romance", "lovers", "sad", "help"));
		ValentineBot.startValentineBotChat(isOwnerPresent, topics);
	}
}
