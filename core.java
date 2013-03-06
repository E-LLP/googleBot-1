import java.util.*;
import java.io.*;
import org.jibble.pircbot.*;
class core {
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(new BufferedReader(new FileReader("settings")));
		String nick = "Siri";
		String server = "irc.andirc.net";
		ArrayList<String> channels = new ArrayList<String>();
		String nspass = "";
		while(s.hasNext()){
			String temp = (String) s.nextLine();
			switch(temp.split("=")[0]){
				case "nick":
					nick = temp.split("=")[1];
				break;
				case "server":
					server = temp.split("=")[1];
				break;
				case "channels":
					String[] chan = temp.split("=")[1].split("\\s");
					for (String channel : chan){
						channels.add(channel);
					}
				break;
				case "nspass":
					nspass = temp.split("=")[1].trim();
				break;
			}


		}
		Bot bot = new Bot(nick, channels, nspass);
		bot.connect(server);
		bot.setVerbose(true);
		//ArrayList<String> fnChan = new ArrayList<String>();
		//fnChan.add("#koush");
		//Bot bot2 = new Bot("Arianus", fnChan);
		//bot2.connect("irc.freenode.net");
		//bot2.setVerbose(true);
	}
}
