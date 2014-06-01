package org.rb.chatbot.core;

/**
 * This class basically holds constant strings that we'll use.
 * @author RB
 *
 */
public class ConstantTextStrings {
	
	/**
	 * The Stranger is typing message !
	 */
	public static final String STRANGER_TYPING = "Stranger is typing...";
	
	/**
	 * The Say Hi ! Message
	 */
	public static final String INTRO_MESSAGE = "You're now chatting with a random stranger";

	/**
	 * The URL
	 */
	public static final String WEBSITE_URL = "http://www.omegle.com/";
		
	/**
	 * The first thing the bot says once the chat starts.
	 */
	public static final String BOT_WELCOME_MESSAGE = "Hi ! I have a confession to make: I'm a bot, not a spam bot, but a love bot. I'll be messaging cheesy lines right now :-). I'll hit one quote for each message you send. TO STOP IT, just type \"stop\" and my owner will speak if he's around. Okay ? :D ";
	
	/**
	 * The message the bot hits when the human doesn't reply for a long time.
	 */
	public static final String BOT_WAITED_TOO_LONG = "I'm leaving. Bye !";

	/**
	 * The goodbye message when I'm around and spying.
	 */
	public static final String BOT_GOODBYE = "Thank you for sticking around ! I hope I brought a smile to your face :D";
	//public static final String BOT_GOODBYE = "Before I leave, I have one thing to ask : Will you be my valentine ? :D\nIf you're already taken (wonder who the lucky person is), I hope it works out for you ! (But I'm still cooler ! :D :D)\n Happy Valentines day !! :) Bye !";

	/**
	 * Owner is present and will speak
	 */
	public static final String BOT_OWNER_SPEAK = "Anyway, my owner will speak now. Bye :(";
	

	/**
	 * The twitter plug in message
	 */	
	public static final String BOT_TWITTER= "You could follow my owner on twitter @revanthb3000.";

	/**
	 * My Omegle Bot ids
	 */
	public static final String BOT_OTHER_SOCIAL_MEDIA =  "Or, you could contact me on other social networks. Look for rbomeglebot on kik, FB or GMail !";
	
	/**
	 * Tells the user how to restart the bot.
	 */
	public static final String BOT_RESTART_INSTRUCTIONS = "If you want to restart this bot, just hit 'Restart' and I'll continue.";
	
	/**
	 * Just a reminder to tell the user that he can stop the bot.
	 */
	public static final String BOT_STOP_REMINDER = "(Just hit 'stop' to get me to stop talking.)";
	
	/**
	 * The rare case. All jokes have been exhausted.
	 */
	public static final String BOT_JOKES_EXHAUSTED = "All quotes exhausted ! Well done, human !! Hit \"stop\" to get me to stop.";
}
