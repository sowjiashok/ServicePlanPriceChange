package helper;

import java.util.Comparator;

import com.model.Message;

public class MessageComparator implements Comparator<Message> {

	// Overriding compare()method of Comparator
	// for ascending order of cgpa
	@Override
	public int compare(Message m1, Message m2) {
		if (m1.getTimestamp() < m2.getTimestamp())
			return -1;
		else if (m1.getTimestamp() > m2.getTimestamp())
			return 1;
		return 0;
	}
}
