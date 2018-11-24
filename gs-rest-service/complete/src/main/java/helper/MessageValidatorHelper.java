package helper;

import java.util.List;

import org.springframework.util.StringUtils;

import com.model.Message;

/*Future Enhancement: Add these validations by making use of a separate class that implements Validator class */
/**
 * @author sowjhanyaashok
 *
 */
public class MessageValidatorHelper {
	/**
	 * Validate message base don input text and username.
	 * 
	 * @param msg
	 * @return
	 */
	public static boolean isMessageValid(Message msg) {

		String text = msg.getText();
		String username = msg.getUsername();

		if (!StringUtils.isEmpty(text) && !StringUtils.isEmpty(username)) {
			return true;
		}
		return false;
	}

	/**
	 * Validate in store message list, based on its size.
	 * 
	 * @param msgList
	 * @return
	 */
	public static boolean areMessagesFromInStoreObjectValid(List<Message> msgList) {

		/* basic validation */
		if (msgList.size() != 0) {
			return true;
		}
		return false;
	}

}
