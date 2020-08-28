package daily.fullclean.springboot.email;

public interface EmailPort {

	boolean sendEmail(EmailBody emailBody);

}
