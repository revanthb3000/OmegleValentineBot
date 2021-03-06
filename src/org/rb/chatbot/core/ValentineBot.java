package org.rb.chatbot.core;

import java.util.ArrayList;

import org.rb.chatbot.preprocessing.ExtractQuotes;

public class ValentineBot {
	
	/**
	 * This is the core function of the project. Starts firefox webdriver, goes
	 * to the website and initiates a chat. Runs in an infinite loop.
	 * 
	 * @param isOwnerPresent
	 * @throws Exception
	 */
	public static void startValentineBotChat(Boolean isOwnerPresent, ArrayList<String> topics) throws Exception {
		ArrayList<String> quotesDataset = ExtractQuotes.getQuotesList();
		WebHandler webHandler = new WebHandler(ConstantTextStrings.WEBSITE_URL);
		webHandler.startBrowser();
		while (true) {
			String fileName = "convs/" + UtilityFunctions.getCurrentTimeStamp() + ".txt";
			String newMessage = "";
			int numOfQuotes = 0;
			ArrayList<String> quotes = new ArrayList<String>(quotesDataset);

			webHandler.startNewChat(topics);
			webHandler.waitForChatStart();

			try {
				webHandler.sendMessage(ConstantTextStrings.BOT_WELCOME_MESSAGE);
				
				// This loop is the course of the whole chat.
				while (true) {
					webHandler.waitForNewMessage();
					newMessage = webHandler.getNewMessage();

					if (newMessage.toLowerCase().contains("stop")) {
						Boolean shouldRestart = stopValentineBot(webHandler, isOwnerPresent);
						if (!shouldRestart) {
							break;
						}
					} else if ((webHandler.getTranscript().contains(
							ConstantTextStrings.BOT_WAITED_TOO_LONG) || webHandler
							.hasDisconnected())) {
						break;
					}

					webHandler.sendMessage(getRandomQuote(quotes));
					numOfQuotes++;
					if (numOfQuotes % 20 == 0)
						webHandler
								.sendMessage(ConstantTextStrings.BOT_STOP_REMINDER);
				}

				if (!webHandler.hasDisconnected())
					webHandler.disconnect();

				UtilityFunctions.writeToFile(webHandler.getTranscript(),
						fileName);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * This basically handles the situation when the user tells the bot to stop.
	 * 
	 * @param webHandler
	 * @param isOwnerPresent
	 * @param insertContactMeInfo 
	 * @return
	 * @throws InterruptedException
	 */
	public static Boolean stopValentineBot(WebHandler webHandler, Boolean isOwnerPresent) throws InterruptedException {
		Boolean shouldRestart = false;
		String chatTranscript = "",  newMessages = "";

		if (isOwnerPresent) {
			UtilityFunctions.playSound();
			webHandler.sendMessage(ConstantTextStrings.BOT_OWNER_SPEAK);
			while (!webHandler.hasDisconnected()) {
				newMessages = webHandler.getTranscript().replace(chatTranscript, "").trim();
				if (newMessages.toLowerCase().contains("restart")) {
					shouldRestart = true;
					break;
				}
				Thread.sleep(10000);
			}
		} else {
			webHandler.sendMessage(ConstantTextStrings.BOT_GOODBYE);
			webHandler.sendMessage(ConstantTextStrings.BOT_RESTART_INSTRUCTIONS);
			webHandler.sendMessage(ConstantTextStrings.BOT_TWITTER);
			webHandler.sendMessage(ConstantTextStrings.BOT_OTHER_SOCIAL_MEDIA);
			chatTranscript = webHandler.getTranscript();
			
			int cnt = 0;
			while (true) {
				newMessages = webHandler.getTranscript().replace(chatTranscript, "").trim();
				if (newMessages.toLowerCase().contains("restart")) {
					shouldRestart = true;
					break;
				}
				if(newMessages.toLowerCase().contains("resetCntYouBOT!")){
					cnt=0;
				}
				cnt += 5000;
				Thread.sleep(5000);
				if ((cnt == 240000) || (webHandler.hasDisconnected())) {
					shouldRestart = false;
					break;
				}
			}
		}
		return shouldRestart;
	}

	/**
	 * Picks up a random quote from the quotes ArrayList, shoots it and removes it
	 * from the list to ensure that it's not repeated again.
	 * 
	 * @param quotes
	 * @return
	 */
	public static String getRandomQuote(ArrayList<String> quotes) {
		if (quotes.size() == 0) {
			return ConstantTextStrings.BOT_JOKES_EXHAUSTED;
		} else {
			int jokeId = UtilityFunctions.getRandomNumber(0, quotes.size() - 1);
			String joke = quotes.get(jokeId);
			quotes.remove(jokeId);
			return joke;
		}
	}

}
