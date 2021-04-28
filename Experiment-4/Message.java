import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Message {
    private String author;
    private String title;
    private String content;
    private String message;
    private int filePointer;
    private int fileLength;

    public Message() {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/message.txt", "r");
        fileLength=randomAccessFile.length();
        randomAccessFile.close();
        filePointer = 0;
    }

    public boolean message() {
        if (filePointer == fileLength) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:/message.txt", "r");
        randomAccessFile.seek(filePointer);
        message = randomAccessFile.readLine();
        filePointer = randomAccessFile.getFilePointer();
        randomAccessFile.close();
        // StringTokenizer st = new StringTokenizer(message);
        StringTokenizer stringTokenizer = new StringTokenizer(message, "&");
        author = stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        content = stringTokenizer.nextToken();
        return true;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}