package co.willbrown.remoteplay.model;

import java.util.HashMap;
import java.util.List;

public class Game {

    private int numberOfRounds = 3;
    private boolean round = false;
    private Player judge;
    private Player winner = null;
    private List<Player> players;
    private HashMap<Player, Integer> score = new HashMap<>();
    private int numberOfPlayers;
    private HashMap<Card, Player> displayedCards = new HashMap<>();
    private Card question;
    private Deck questions = new Deck(
            new Card("How did I lose my virginity?", CardType.QUESTION),
            new Card("Why can't I sleep at night?", CardType.QUESTION),
            new Card("What's that smell?", CardType.QUESTION),
            new Card("I got 99 problems but ___________ ain't one.", CardType.QUESTION),
            new Card("Maybe she's born with it. Maybe it's ___________.", CardType.QUESTION),
            new Card("What's the next Happy Meal toy?", CardType.QUESTION),
            new Card("Here is the church Here is the steeple Open the doors And there is ___________.", CardType.QUESTION),
            new Card("It's a pity that kids these days are all getting involved with ___________.", CardType.QUESTION),
            new Card("Today on Maury \"Help! My son is ___________!\"", CardType.QUESTION),
            new Card("Alternative medicine is now embracing the curative powers of ___________.", CardType.QUESTION),
            new Card("What's that sound?", CardType.QUESTION),
            new Card("What ended my last relationship?", CardType.QUESTION),
            new Card("I drink to forget ___________.", CardType.QUESTION),
            new Card("I'm sorry Professor but I couldn't complete my homework because of ___________.", CardType.QUESTION),
            new Card("What is Batman's guilty pleasure?", CardType.QUESTION),
            new Card("Whats a girl's best friend?", CardType.QUESTION),
            new Card("TSA guidelines now prohibit ___________ on airplanes.", CardType.QUESTION),
            new Card("___________. That's how I want to die.", CardType.QUESTION),
            new Card("I get by with a little help from ___________.", CardType.QUESTION),
            new Card("Instead of coal Santa now gives the bad children ___________.", CardType.QUESTION),
            new Card("What's the most emo?", CardType.QUESTION),
            new Card("A romantic, candlelit dinner would be incomplete without ___________.", CardType.QUESTION),
            new Card("___________. Betcha can't have just one!", CardType.QUESTION),
            new Card("White people like ___________.", CardType.QUESTION),
            new Card("___________. High five, bro.", CardType.QUESTION),
            new Card("Next from J.K Rowling: Harry Potter and the Chamber of ___________.", CardType.QUESTION),
            new Card("What will always get you laid?", CardType.QUESTION)
            );
    private Deck answers = new Deck(
            new Card("Being on fire.", CardType.ANSWER),
            new Card("Racism.", CardType.ANSWER),
            new Card("Old-people smell.", CardType.ANSWER),
            new Card("A micropenis.", CardType.ANSWER),
            new Card("Women in yogurt commercials.", CardType.ANSWER),
            new Card("Classist undertones.", CardType.ANSWER),
            new Card("Not giving a shit about the Third World.", CardType.ANSWER),
            new Card("Inserting a mason jar into my anus.", CardType.ANSWER),
            new Card("Court-ordered rehab.", CardType.ANSWER),
            new Card("A windmill full of corpses.", CardType.ANSWER),
            new Card("The gays.", CardType.ANSWER),
            new Card("An oversized lollipop.", CardType.ANSWER),
            new Card("African children.", CardType.ANSWER),
            new Card("An asymmetric boob job.", CardType.ANSWER),
            new Card("Bingeing and purging.", CardType.ANSWER),
            new Card("The hardworking Mexican.", CardType.ANSWER),
            new Card("An Oedipus complex.", CardType.ANSWER),
            new Card("A tiny horse.", CardType.ANSWER),
            new Card("Boogers.", CardType.ANSWER),
            new Card("Penis envy.", CardType.ANSWER),
            new Card("Barack Obama.", CardType.ANSWER),
            new Card("My humps.", CardType.ANSWER),
            new Card("Scientology.", CardType.ANSWER),
            new Card("Dry heaving.", CardType.ANSWER),
            new Card("Skeletor.", CardType.ANSWER),
            new Card("Darth Vader.", CardType.ANSWER),
            new Card("Figgy pudding.", CardType.ANSWER),
            new Card("Advice from a wise, old black man.", CardType.ANSWER),
            new Card("Five-Dollar Footlongs.", CardType.ANSWER),
            new Card("Elderly Japanese men.", CardType.ANSWER),
            new Card("Free Samples.", CardType.ANSWER),
            new Card("Estrogen.", CardType.ANSWER),
            new Card("Sexual tension.", CardType.ANSWER),
            new Card("Famine.", CardType.ANSWER),
            new Card("A stray pube.", CardType.ANSWER),
            new Card("Men.", CardType.ANSWER),
            new Card("Heartwarming orphans.", CardType.ANSWER),
            new Card("Chunks of dead hitchhiker.", CardType.ANSWER),
            new Card("A bag of magic beans.", CardType.ANSWER),
            new Card("Repression.", CardType.ANSWER),
            new Card("Prancing.", CardType.ANSWER),
            new Card("My relationship status.", CardType.ANSWER),
            new Card("Overcompensation.", CardType.ANSWER),
            new Card("Peeing a little bit.", CardType.ANSWER),
            new Card("Pooping back and forth Forever.", CardType.ANSWER),
            new Card("A ball of earwax, semen and toenail clippings.", CardType.ANSWER),
            new Card("Testicular torsion.", CardType.ANSWER),
            new Card("The Devil himself.", CardType.ANSWER),
            new Card("The World of Warcraft.", CardType.ANSWER),
            new Card("Dick Cheney.", CardType.ANSWER),
            new Card("MechaHitler.", CardType.ANSWER),
            new Card("Being fabulous.", CardType.ANSWER),
            new Card("Pictures of boobs.", CardType.ANSWER),
            new Card("A gentle caress of the inner thigh.", CardType.ANSWER),
            new Card("The Amish.", CardType.ANSWER),
            new Card("The rhythms of Africa.", CardType.ANSWER),
            new Card("Lance Armstrong's missing testicle.", CardType.ANSWER),
            new Card("Pedophiles.", CardType.ANSWER),
            new Card("The Pope.", CardType.ANSWER),
            new Card("Flying sex snakes.", CardType.ANSWER),
            new Card("Sarah Palin.", CardType.ANSWER),
            new Card("Feeding Rosie O'Donnell", CardType.ANSWER),
            new Card("Sexy pillow fights.", CardType.ANSWER),
            new Card("Invading Poland.", CardType.ANSWER),
            new Card("Cybernetic enhancements.", CardType.ANSWER),
            new Card("Civilian casualties.", CardType.ANSWER),
            new Card("Jobs.", CardType.ANSWER),
            new Card("The female orgasm.", CardType.ANSWER),
            new Card("Bitches.", CardType.ANSWER),
            new Card("The Boy Scouts of America.", CardType.ANSWER),
            new Card("Auschwitz.", CardType.ANSWER),
            new Card("Finger painting.", CardType.ANSWER),
            new Card("The Care Bear Stare.", CardType.ANSWER),
            new Card("The Jews.", CardType.ANSWER),
            new Card("Being marginalized.", CardType.ANSWER),
            new Card("The Blood of Christ.", CardType.ANSWER),
            new Card("Dead parents.", CardType.ANSWER),
            new Card("The art of seduction.", CardType.ANSWER),
            new Card("Dying of dysentery.", CardType.ANSWER),
            new Card("My.Clean right behind you.", CardType.ANSWER)
    );

    public Game() {
        createQuestionDeck();
        questions.suffle();
        answers.suffle();
    }

    public Game(List<Player> players) {
        //default of 3
        this.players = players;
        addPlayersToScore(players);
        this.judge = players.get(0);
        this.numberOfPlayers = players.size();
        questions.suffle();
        answers.suffle();
    }

    public boolean getRound() {
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private void addPlayersToScore(List<Player> players) {
        for(Player player : players){
            this.getScore().put(player, 0);
        }
    }

    public Card getQuestion() {
        return question;
    }

    public void setQuestion(Card question) {
        this.question = question;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Player getJudge() {
        return judge;
    }

    public void setJudge(Player judge) {
        this.judge = judge;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public HashMap<Player, Integer> getScore() {
        return score;
    }

    public void setScore(HashMap<Player, Integer> score) {
        this.score = score;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Deck getQuestions() {
        return questions;
    }

    public void setQuestions(Deck questions) {
        this.questions = questions;
    }

    public Deck getAnswers() {
        return answers;
    }

    public void setAnswers(Deck answers) {
        this.answers = answers;
    }

    public HashMap<Card, Player> getDisplayedCards() {
        return displayedCards;
    }

    public void setDisplayedCards(HashMap<Card, Player> displayedCards) {
        this.displayedCards = displayedCards;
    }

    public void createQuestionDeck(){
        questions.addCards(
                new Card("Question 1", CardType.QUESTION),
                new Card("Question 2", CardType.QUESTION),
                new Card("Question 3", CardType.QUESTION),
                new Card("Question 4", CardType.QUESTION),
                new Card("Question 5", CardType.QUESTION),
                new Card("Question 6", CardType.QUESTION),
                new Card("Question 7", CardType.QUESTION)
        );
    }

    public void createAnswerDeck(){
        answers.addCards(
                new Card("1", CardType.ANSWER),
                new Card("2", CardType.ANSWER),
                new Card("3", CardType.ANSWER),
                new Card("4", CardType.ANSWER),
                new Card("5", CardType.ANSWER),
                new Card("6", CardType.ANSWER),
                new Card("7", CardType.ANSWER),
                new Card("8", CardType.ANSWER),
                new Card("9", CardType.ANSWER),
                new Card("10", CardType.ANSWER),
                new Card("11", CardType.ANSWER),
                new Card("12", CardType.ANSWER),
                new Card("13", CardType.ANSWER),
                new Card("14", CardType.ANSWER),
                new Card("15", CardType.ANSWER),
                new Card("16", CardType.ANSWER),
                new Card("17", CardType.ANSWER),
                new Card("18", CardType.ANSWER),
                new Card("19", CardType.ANSWER),
                new Card("20", CardType.ANSWER),
                new Card("21", CardType.ANSWER),
                new Card("22", CardType.ANSWER),
                new Card("23", CardType.ANSWER),
                new Card("24", CardType.ANSWER),
                new Card("25", CardType.ANSWER),
                new Card("26", CardType.ANSWER),
                new Card("27", CardType.ANSWER),
                new Card("28", CardType.ANSWER),
                new Card("29", CardType.ANSWER),
                new Card("30", CardType.ANSWER),
                new Card("31", CardType.ANSWER),
                new Card("32", CardType.ANSWER),
                new Card("33", CardType.ANSWER),
                new Card("34", CardType.ANSWER),
                new Card("35", CardType.ANSWER),
                new Card("36", CardType.ANSWER),
                new Card("37", CardType.ANSWER),
                new Card("38", CardType.ANSWER),
                new Card("39", CardType.ANSWER),
                new Card("40", CardType.ANSWER)
        );
    }

    public void dealFirstHand(){
        for(Player player: players){
            for(int i = 0; i <= 7; i++){
                player.getHand().addCard(this.drawAnswer());
            }
        }
    }

    public Card drawQuestion(){
        Card topQuestion = questions.getCardStack().pop();
        this.question = topQuestion;

        return topQuestion;
    }

    public Card drawAnswer() {
        return answers.getCardStack().pop();
    }

    public boolean isJudge(Player player){
        return this.judge.equals(player);
    }

    public void nextJudge() {
        if(getPlayerNumber(this.judge) != ((players.size() - 1))){
            int currentJudge = getPlayerNumber(this.judge);
            this.judge = players.get(currentJudge + 1);
        }else {
            this.judge = players.get(0);
        }
    }

    public int getPlayerNumber(Player player){
        for(int i = 0; i < players.size(); i++){
            if(player.equals(players.get(i))) return i;
        }
        return -1;
    }
}
