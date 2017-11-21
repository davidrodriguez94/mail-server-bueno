/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // The text of the message.
    private String message;
    // The text of the subject.
    private String subject;

    private boolean encriptado;
    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(boolean encripta,String from, String to, String subject, String message)
    {
        this.encriptado = encripta;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @return The text of subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        if(encriptado = false){
            System.out.println("From: " + from);
            System.out.println("To: " + to);
            System.out.println("Subject: " + subject);
            System.out.println("Message: " + message);
        }
        else{
            if(encriptado = true){
                System.out.println("From: " + from);
                System.out.println("To: " + to);
                System.out.println("Subject: " + subject);
                message = message.replace("$\\","a");
                message = message.replace("^", "A");
                message = message.replace("*", "e");
                message = message.replace("Ç", "E");
                message = message.replace("º", "i");
                message = message.replace("=", "I");
                message = message.replace("·", "o");
                message = message.replace("!", "O");
                message = message.replace("ª", "u");
                message = message.replace("+", "U");
                System.out.println("Message: " + message);
            }
        }
    }
}
