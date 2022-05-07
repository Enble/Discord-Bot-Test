package springbot;

import javax.security.auth.login.LoginException;
import javax.swing.MenuElement;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
    public static JDA jda;
    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault("OTcyMzk1ODA5Nzc1Njg5Nzc4.Gy6Ges.ajkARrdEpQPZNEewifogTeN82ywyGqzCHiTMYY").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("테스트를 위한 봇입니다."));

        jda.addEventListener(new Main());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String prefix = "!";
        Message message = new Message();
        if(!event.getAuthor().isBot()) {
            if(args[0].equals(prefix + "help") || args[0].equals(prefix + "h")) {
                message.help();
                event.getChannel().sendMessage(message.getMsg()).queue();
            }
        }
    }
}
