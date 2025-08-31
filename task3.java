/*TASK 3: Artificial Intelligence Chatbot
● Create a Java-based chatbot for interactive communication.
● Use Natural Language Processing (NLP) techniques.
● Implement machine learning logic or rule-based answers.
● Train the bot to respond to frequently asked questions.
● Integrate with a GUI or web interface for real-time interaction */
import java.util.*;  // for scanner class that is used for input and output ok

class Chatbot {
    private Map<String, String> knowledgeBase;

    public Chatbot() {
        knowledgeBase = new HashMap<>();

        // Predefined FAQ responses
        knowledgeBase.put("hello", "Hello! How can I help you today?");
        knowledgeBase.put("hi", "Hi there! What can I do for you?");
        knowledgeBase.put("how are you", "I'm just a chatbot, but I'm doing great! Thanks for asking.");
        knowledgeBase.put("your name", "I'm a simple Java Chatbot created for this assignment.");
        knowledgeBase.put("bye", "Goodbye! Have a nice day!");
        knowledgeBase.put("thanks", "You're welcome! Always here to help.");
        knowledgeBase.put("what is ai", "Artificial Intelligence is the simulation of human intelligence by machines.");
        knowledgeBase.put("what is java", "Java is a high-level, object-oriented programming language.");
        knowledgeBase.put("what is ml", "Machine learning is the subset of AI that enables the computer to learn from data and improve their perfromance over time without being explicitly programmed");
    }

    public String getResponse(String userInput) {
        userInput = userInput.toLowerCase();

        // Check for exact matches
        if (knowledgeBase.containsKey(userInput)) {
            return knowledgeBase.get(userInput);
        }

        // Simple keyword detection
        if (userInput.contains("weather")) {
            return "I can't check live weather now, but it's always a good day to code!";
        } else if (userInput.contains("help")) {
            return "Sure! You can ask me about AI, Java, or general greetings.";
        }

        return "Sorry, I don't understand that. Can you rephrase?";
    }
}

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chatbot chatbot = new Chatbot();

        System.out.println("=== Welcome to Java AI Chatbot ===");
        System.out.println("Type 'bye' to exit the chat.\n");

        while (true) {
            System.out.print("You: ");
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: " + chatbot.getResponse("bye"));
                break;
            }

            String response = chatbot.getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }

        sc.close();
    }
}

