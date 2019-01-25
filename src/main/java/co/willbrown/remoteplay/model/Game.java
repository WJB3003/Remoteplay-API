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
            new Card("What will always get you laid?", CardType.QUESTION),
            new Card("In L.A. County Jail, word is you can trade 200 cigarettes for ___________.", CardType.QUESTION),
            new Card("What did I bring back from Mexico?", CardType.QUESTION),
            new Card("What don't you want to find in your Kung Pao chicken?", CardType.QUESTION),
            new Card("What will I bring back in time to convince people that I am a powerful wizard?", CardType.QUESTION),
            new Card("How am I maintaining my relationship status?", CardType.QUESTION),
            new Card("___________. It's a trap!", CardType.QUESTION),
            new Card("Coming to Broadway this season, ___________: The Musical.", CardType.QUESTION),
            new Card("After the earthquake, Sean Penn brought ___________ to the people of Haiti.", CardType.QUESTION),
            new Card("Next on ESPN2, the World Series of ___________.", CardType.QUESTION),
            new Card("But before I kill you, Mr.Bond, I must show you ___________.", CardType.QUESTION),
            new Card("What gives me uncontrollable gas?", CardType.QUESTION),
            new Card("The new Chevy Tahoe. With the power and space to take ___________ everywhere you go.", CardType.QUESTION),
            new Card("The class field trip was completely ruined by ___________.", CardType.QUESTION),
            new Card("When Paraoh remained unmoved, Moses called down a Plague of ___________.", CardType.QUESTION),
            new Card("What's my secret power?", CardType.QUESTION),
            new Card("What's there a ton of in heaven?", CardType.QUESTION),
            new Card("What would grandma find disturbing, yet oddly charming?", CardType.QUESTION),
            new Card("What did there U.S. airdrop on the children of Afghanistan?", CardType.QUESTION),
            new Card("What helps Obama unwind?", CardType.QUESTION),
            new Card("What did Vin Diesel eat for dinner?", CardType.QUESTION),
            new Card("___________: good to the last drop.", CardType.QUESTION),
            new Card("Why am I sicky?", CardType.QUESTION),
            new Card("What gets better with age?", CardType.QUESTION),
            new Card("___________: kid-tested mother-approved.", CardType.QUESTION),
            new Card("Daddy, why is mommy crying?", CardType.QUESTION),
            new Card("What's Teach for America using to inspire inner city student to succeed?", CardType.QUESTION),
            new Card("A recent laboratory study shows that undergraduates have 50% less sex after being exposed to ___________.", CardType.QUESTION),
            new Card("Life for American Indians was forever changed when the White Man introduced them to ___________.", CardType.QUESTION),
            new Card("I don't know with what weapons WWIII will be fought with but WWIV will be fought with ___________.", CardType.QUESTION),
            new Card("Why do I hurt all over?", CardType.QUESTION),
            new Card("What am I giving up for Lent?", CardType.QUESTION),
            new Card("What's George W. Bush thinking about right now?", CardType.QUESTION),
            new Card("The Smithsonian Museum of Natural History has just opened an interactive exhibit on ___________.", CardType.QUESTION),
            new Card("When I am President of United State, I will create the Department of ___________.", CardType.QUESTION),
            new Card("When I am a billionaire, I shall erect a 50-foot statue to commemorate ___________.", CardType.QUESTION),
            new Card("What's my anti-drug?", CardType.QUESTION),
            new Card("What never fails to liven up the party?", CardType.QUESTION),
            new Card("What's the new fad diet?", CardType.QUESTION),
            new Card("Fun tip! When your man asks you to go down on him, try suprising him with ___________ instead.", CardType.QUESTION)
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
            new Card("My.Clean right behind you.", CardType.ANSWER),
            new Card("Magnets.", CardType.ANSWER),
            new Card("Jewish fraternities.", CardType.ANSWER),
            new Card("Hot Pockets.", CardType.ANSWER),
            new Card("Natalie Portman.", CardType.ANSWER),
            new Card("Agriculture.", CardType.ANSWER),
            new Card("Judge Judy.", CardType.ANSWER),
            new Card("Surprise sex!", CardType.ANSWER),
            new Card("The homosexual agenda.", CardType.ANSWER),
            new Card("Robert Downey, Jr.", CardType.ANSWER),
            new Card("The Trail of Tears.", CardType.ANSWER),
            new Card("An M. Night Shyamalan plot twist.", CardType.ANSWER),
            new Card("Funky fresh rhymes.", CardType.ANSWER),
            new Card("The light of a billion suns.", CardType.ANSWER),
            new Card("Amputees.", CardType.ANSWER),
            new Card("Throwing a virgin into a volcano.", CardType.ANSWER),
            new Card("Italians.", CardType.ANSWER),
            new Card("Explosions.", CardType.ANSWER),
            new Card("A good sniff.", CardType.ANSWER),
            new Card("Destroying the evidence.", CardType.ANSWER),
            new Card("Children on leashes.", CardType.ANSWER),
            new Card("Catapults.", CardType.ANSWER),
            new Card("One trillion dollars.", CardType.ANSWER),
            new Card("Friends with benefits.", CardType.ANSWER),
            new Card("Dying.", CardType.ANSWER),
            new Card("Silence.", CardType.ANSWER),
            new Card("Growing a pair.", CardType.ANSWER),
            new Card("YOU MUST CONSTRUCT ADDITIONAL PYLONS.", CardType.ANSWER),
            new Card("Justin Bieber.", CardType.ANSWER),
            new Card("The Holy Bible.", CardType.ANSWER),
            new Card("Balls.", CardType.ANSWER),
            new Card("Praying the gay away.", CardType.ANSWER),
            new Card("Teenage pregnancy.", CardType.ANSWER),
            new Card("German dungeon porn.", CardType.ANSWER),
            new Card("The invisible hand.", CardType.ANSWER),
            new Card("My inner demons.", CardType.ANSWER),
            new Card("Powerful thighs.", CardType.ANSWER),
            new Card("Getting naked and watching Nickelodeon.", CardType.ANSWER),
            new Card("Crippling debt.", CardType.ANSWER),
            new Card("Kamikaze pilots.", CardType.ANSWER),
            new Card("Teaching a robot to love.", CardType.ANSWER),
            new Card("Police brutality.", CardType.ANSWER),
            new Card("Horse Meat.", CardType.ANSWER),
            new Card("All-you-can-eat shrimp for $4.99.", CardType.ANSWER),
            new Card("Heteronormativity.", CardType.ANSWER),
            new Card("Michael Jackson.", CardType.ANSWER),
            new Card("A really cool hat.", CardType.ANSWER),
            new Card("Copping a feel.", CardType.ANSWER),
            new Card("Crystal meth.", CardType.ANSWER),
            new Card("Shapeshifters.", CardType.ANSWER),
            new Card("Fingering.", CardType.ANSWER),
            new Card("A disappointing birthday party.", CardType.ANSWER),
            new Card("The Patriarchy.", CardType.ANSWER),
            new Card("My soul.", CardType.ANSWER),
            new Card("A sausage festival.", CardType.ANSWER),
            new Card("The chronic.", CardType.ANSWER),
            new Card("Eugenics.", CardType.ANSWER),
            new Card("Synergistic management solutions.", CardType.ANSWER),
            new Card("RoboCop.", CardType.ANSWER),
            new Card("Serfdom.", CardType.ANSWER),
            new Card("Stephen Hawking talking dirty.", CardType.ANSWER),
            new Card("A man on the brink of orgasm.", CardType.ANSWER),
            new Card("Fiery poops.", CardType.ANSWER),
            new Card("Public ridicule.", CardType.ANSWER),
            new Card("White-man scalps.", CardType.ANSWER),
            new Card("The morbidly obese.", CardType.ANSWER),
            new Card("Object permanence.", CardType.ANSWER),
            new Card("GoGurt.", CardType.ANSWER),
            new Card("LockJaw.", CardType.ANSWER),
            new Card("Joe Biden.", CardType.ANSWER),
            new Card("Bio-engineered assault turtles with acid breath.", CardType.ANSWER),
            new Card("Wet dreams.", CardType.ANSWER),
            new Card("Hip hop jewels.", CardType.ANSWER),
            new Card("Firing a rifle into the air while balls deep in a squealing hog.", CardType.ANSWER),
            new Card("Panda sex.", CardType.ANSWER),
            new Card("Necrophilla.", CardType.ANSWER),
            new Card("Grave robbing.", CardType.ANSWER),
            new Card("A bleached asshole.", CardType.ANSWER),
            new Card("Muhammad (Praise Be Unto Him)/", CardType.ANSWER),
            new Card("Multiple stab wounds.", CardType.ANSWER),
            new Card("Daniel Radcliffe's delicious asshole.", CardType.ANSWER),
            new Card("A monkey smoking a cigar.", CardType.ANSWER),
            new Card("Smegma", CardType.ANSWER),
            new Card("A live studio audience.", CardType.ANSWER),
            new Card("Making a pouty face.", CardType.ANSWER),
            new Card("The violation of our most basic human rights.", CardType.ANSWER),
            new Card("Unfathomable stupidity.", CardType.ANSWER),
            new Card("Sunshine and rainbows.", CardType.ANSWER),
            new Card("Whipping it out.", CardType.ANSWER),
            new Card("The token minority.", CardType.ANSWER),
            new Card("The terrorists.", CardType.ANSWER),
            new Card("The Three-Fifths compromise.", CardType.ANSWER),
            new Card("A snapping turtle biting the tip of our penis.", CardType.ANSWER),
            new Card("Vehicular manslaughter.", CardType.ANSWER),
            new Card("The Great Depression.", CardType.ANSWER),
            new Card("Emotions.", CardType.ANSWER),
            new Card("Getting so angry that you pop a boner.", CardType.ANSWER),
            new Card("Same-sex ice dancing.", CardType.ANSWER),
            new Card("An M16 assault rifle.", CardType.ANSWER),
            new Card("Man meat.", CardType.ANSWER),
            new Card("Incest.", CardType.ANSWER),
            new Card("A foul mouth.", CardType.ANSWER),
            new Card("Flightless birds.", CardType.ANSWER),
            new Card("Doing the right thing.", CardType.ANSWER),
            new Card("When you fart and a little bit comes out.", CardType.ANSWER),
            new Card("Frolicking.", CardType.ANSWER),
            new Card("Being a dick to children.", CardType.ANSWER),
            new Card("Poopy diapers.", CardType.ANSWER),
            new Card("Seeing grandma naked.", CardType.ANSWER),
            new Card("Raptor attcks.", CardType.ANSWER),
            new Card("Swooping.", CardType.ANSWER),
            new Card("Concealing a boner.", CardType.ANSWER),
            new Card("Full frontal nudity.", CardType.ANSWER),
            new Card("Vigorous jizz hands.", CardType.ANSWER),
            new Card("Nipple blades.", CardType.ANSWER),
            new Card("A bitch slap.", CardType.ANSWER),
            new Card("Michelle Obama's Arms.", CardType.ANSWER),
            new Card("Mouth herpes.", CardType.ANSWER),
            new Card("A robust monogoloid.", CardType.ANSWER),
            new Card("Mutually-assured destruction.", CardType.ANSWER),
            new Card("The Rapture.", CardType.ANSWER),
            new Card("Road head.", CardType.ANSWER),
            new Card("Stalin.", CardType.ANSWER),
            new Card("Lactation.", CardType.ANSWER),
            new Card("Hurricane Katrina.", CardType.ANSWER),
            new Card("The true meaning of Christmas.", CardType.ANSWER),
            new Card("Self-loathing.", CardType.ANSWER),
            new Card("A brain tumor.", CardType.ANSWER),
            new Card("Dead babies.", CardType.ANSWER),
            new Card("New Age music.", CardType.ANSWER),
            new Card("A thermonuclear detonation.", CardType.ANSWER),
            new Card("Geese.", CardType.ANSWER),
            new Card("Kanye West.", CardType.ANSWER),
            new Card("God.", CardType.ANSWER),
            new Card("A spastic nerd.", CardType.ANSWER),
            new Card("Harry Potter erotica.", CardType.ANSWER),
            new Card("Kids with ass cancer.", CardType.ANSWER),
            new Card("Lumberjack fantasies.", CardType.ANSWER),
            new Card("The American Dream.", CardType.ANSWER),
            new Card("Puberty.", CardType.ANSWER),
            new Card("Sweet, sweet vengeance.", CardType.ANSWER),
            new Card("Winking at old people.", CardType.ANSWER),
            new Card("The wonders of the Orient.", CardType.ANSWER),
            new Card("Oompa-Loompas.", CardType.ANSWER),
            new Card("Authentic Mexican cuisine.", CardType.ANSWER),
            new Card("Preteens.", CardType.ANSWER),
            new Card("The Little Engine That Could.", CardType.ANSWER),
            new Card("A Fleshlight.", CardType.ANSWER),
            new Card("Erectile dysfunction.", CardType.ANSWER),
            new Card("Having anuses for eyes.", CardType.ANSWER),
            new Card("Rush Limbaugh's soft, shitty body.", CardType.ANSWER),
            new Card("Saxophone solos.", CardType.ANSWER),
            new Card("Land mines.", CardType.ANSWER),
            new Card("Running out of semen.", CardType.ANSWER),
            new Card("Me time.", CardType.ANSWER),
            new Card("Nickelback.", CardType.ANSWER),
            new Card("Vigilante justice.", CardType.ANSWER),
            new Card("The South.", CardType.ANSWER),
            new Card("Opposable thumbs.", CardType.ANSWER),
            new Card("Ghosts.", CardType.ANSWER),
            new Card("Alcoholism.", CardType.ANSWER),
            new Card("Poorly-timed Holocaust jokes.", CardType.ANSWER),
            new Card("Inappropriate yodeling.", CardType.ANSWER),
            new Card("Battlefield amputations.", CardType.ANSWER),
            new Card("Exactly what you'd expect.", CardType.ANSWER),
            new Card("A time travel paradox.", CardType.ANSWER),
            new Card("AXE Body Spray.", CardType.ANSWER),
            new Card("The pirate's life.", CardType.ANSWER),
            new Card("Saying \"I love you.\"", CardType.ANSWER),
            new Card("A sassy black woman.", CardType.ANSWER),
            new Card("Being a motherfucking sorcerer.", CardType.ANSWER),
            new Card("A mopey zoo lion.", CardType.ANSWER),
            new Card("A murder most foul.", CardType.ANSWER),
            new Card("A falcon with a cap on it's head.", CardType.ANSWER),
            new Card("Farting and walking away.", CardType.ANSWER),
            new Card("A mating display.", CardType.ANSWER),
            new Card("The Chinese gymnastics team.", CardType.ANSWER),
            new Card("Friction.", CardType.ANSWER),
            new Card("Asians who aren't good at math.", CardType.ANSWER),
            new Card("Fear itself.", CardType.ANSWER),
            new Card("A can of whoop-ass.", CardType.ANSWER),
            new Card("Yeast.", CardType.ANSWER),
            new Card("Lunchables.", CardType.ANSWER),
            new Card("Licking things to claim them as your own.", CardType.ANSWER),
            new Card("Vikings.", CardType.ANSWER),
            new Card("The Kool-Aid Man.", CardType.ANSWER),
            new Card("Hot cheese.", CardType.ANSWER),
            new Card("Nicolas Cage.", CardType.ANSWER),
            new Card("A defective condom.", CardType.ANSWER),
            new Card("The inevitable heat death of the universe.", CardType.ANSWER),
            new Card("Republiacans.", CardType.ANSWER),
            new Card("William Shatner.", CardType.ANSWER),
            new Card("Tentacle porn.", CardType.ANSWER),
            new Card("Sperm whales.", CardType.ANSWER),
            new Card("Lady Gaga.", CardType.ANSWER),
            new Card("The wrath of Vladimir Putin.", CardType.ANSWER),
            new Card("Gloryholes.", CardType.ANSWER),
            new Card("Daddy issues.", CardType.ANSWER),
            new Card("A mime having a stroke.", CardType.ANSWER),
            new Card("White people.", CardType.ANSWER),
            new Card("A lifetime of sadness.", CardType.ANSWER),
            new Card("Tasteful sideboob.", CardType.ANSWER),
            new Card("A sea of troubles.", CardType.ANSWER),
            new Card("Nazis.", CardType.ANSWER),
            new Card("A cooler full of organs.", CardType.ANSWER),
            new Card("Giving 110%.", CardType.ANSWER),
            new Card("Doin' it in the butt.", CardType.ANSWER),
            new Card("John Wilkes Booth.", CardType.ANSWER),
            new Card("Holding down a child and farting all over him.", CardType.ANSWER),
            new Card("A homoerotic volleyball montage.", CardType.ANSWER),
            new Card("Puppies!", CardType.ANSWER),
            new Card("Natural male enhancement.", CardType.ANSWER),
            new Card("Brown people.", CardType.ANSWER),
            new Card("Dropping a chandelier on your enemies and riding on rope up.", CardType.ANSWER),
            new Card("Soup that is too hot.", CardType.ANSWER),
            new Card("Sex with Patrick Star.", CardType.ANSWER),
            new Card("Hormone injections.", CardType.ANSWER),
            new Card("Pulling out.", CardType.ANSWER),
            new Card("The Big Bang.", CardType.ANSWER),
            new Card("Switching to Geivo.", CardType.ANSWER),
            new Card("Giving birth to the Antichrist.", CardType.ANSWER),
            new Card("Dark and mysterious forces beyond our control.", CardType.ANSWER),
            new Card("Christopher Walken.", CardType.ANSWER),
            new Card("Count Chocula.", CardType.ANSWER),
            new Card("The Hamburglar.", CardType.ANSWER),
            new Card("Not reciprocating oral sex.", CardType.ANSWER),
            new Card("Aaron Burr.", CardType.ANSWER),
            new Card("Hot people.", CardType.ANSWER),
            new Card("Foreskin.", CardType.ANSWER),
            new Card("Assless chaps.", CardType.ANSWER),
            new Card("The miracle of childbirth.", CardType.ANSWER),
            new Card("Waiting 'til marriage.", CardType.ANSWER),
            new Card("Two midgets shitting into a bucket.", CardType.ANSWER),
            new Card("Adderall.", CardType.ANSWER),
            new Card("A sad handjob.", CardType.ANSWER),
            new Card("Cheating in the Special Olympics.", CardType.ANSWER),
            new Card("The glass ceiling.", CardType.ANSWER),
            new Card("The Hustle.", CardType.ANSWER),
            new Card("Miley Cyrus at 55.", CardType.ANSWER),
            new Card("Our first chimpanzee president.", CardType.ANSWER),
            new Card("Breaking out into song and dance.", CardType.ANSWER),
            new Card("A Super Soaker full of cat pee.", CardType.ANSWER),
            new Card("The Underground Railroad.", CardType.ANSWER),
            new Card("Home video of Oprah sobbing into a Lean Cuisine.", CardType.ANSWER),
            new Card("The Rev. Dr. Martin Luther King, Jr.", CardType.ANSWER),
            new Card("Extremely tight pants.", CardType.ANSWER),
            new Card("Third base.", CardType.ANSWER),
            new Card("Waking up half-naked in a Denny's parking lot.", CardType.ANSWER),
            new Card("The cool refreshing taste of Pepsi.", CardType.ANSWER),
            new Card("White privilege.", CardType.ANSWER),
            new Card("Hope.", CardType.ANSWER),
            new Card("Taking off your shirt.", CardType.ANSWER),
            new Card("Smallpox Blankets.", CardType.ANSWER),
            new Card("Ethnic cleansing.", CardType.ANSWER),
            new Card("Queefing.", CardType.ANSWER),
            new Card("Helplessly giggling at the mention of Hutus and Tutsis.", CardType.ANSWER),
            new Card("Getting really high.", CardType.ANSWER),
            new Card("Natural selection.", CardType.ANSWER),
            new Card("A gassy antelope.", CardType.ANSWER),
            new Card("My sex life.", CardType.ANSWER),
            new Card("Arnold Schwarzenegger.", CardType.ANSWER),
            new Card("Pretending to care.", CardType.ANSWER),
            new Card("Ronald Reagan.", CardType.ANSWER),
            new Card("Toni Morrison's vagina.", CardType.ANSWER),
            new Card("An ugly face.", CardType.ANSWER),
            new Card("My black ass.", CardType.ANSWER),
            new Card("BATMAN!!!", CardType.ANSWER),
            new Card("Homeless people.", CardType.ANSWER),
            new Card("Racially-biased SAT questions.", CardType.ANSWER),
            new Card("Centaurs.", CardType.ANSWER),
            new Card("A salty surprise.", CardType.ANSWER),
            new Card("72 virgins.", CardType.ANSWER),
            new Card("Embryonic stem cells.", CardType.ANSWER),
            new Card("Pixelated bukkake.", CardType.ANSWER),
            new Card("Seppuku.", CardType.ANSWER),
            new Card("An icepick lobotomy.", CardType.ANSWER),
            new Card("Genuine human connection.", CardType.ANSWER),
            new Card("Menstrual rage.", CardType.ANSWER),
            new Card("Sexual peeing.", CardType.ANSWER),
            new Card("An endless stream of diarrhea.", CardType.ANSWER),
            new Card("Shaquille O'Neal's acting career.", CardType.ANSWER),
            new Card("Horrifying laser hair removal accidents.", CardType.ANSWER),
            new Card("Autocannibalism.", CardType.ANSWER),
            new Card("A fetus.", CardType.ANSWER),
            new Card("Riding off into the sunset.", CardType.ANSWER),
            new Card("Goblins.", CardType.ANSWER),
            new Card("Eating the last known bison.", CardType.ANSWER),
            new Card("Shiny objects.", CardType.ANSWER),
            new Card("Being rich.", CardType.ANSWER),
            new Card("A Bop It.", CardType.ANSWER),
            new Card("Leprosy.", CardType.ANSWER),
            new Card("World peace.", CardType.ANSWER),
            new Card("Dick fingers.", CardType.ANSWER),
            new Card("Chainsaws for hands.", CardType.ANSWER),
            new Card("The Make-A-Wish Foundation.", CardType.ANSWER),
            new Card("Penis breath.", CardType.ANSWER),
            new Card("Laying an egg.", CardType.ANSWER),
            new Card("The folly of man.", CardType.ANSWER),
            new Card("My genitals.", CardType.ANSWER),
            new Card("Grandma.", CardType.ANSWER),
            new Card("Flesh-eating bacteria.", CardType.ANSWER),
            new Card("Poor people.", CardType.ANSWER),
            new Card("50,000 volts straight to the nipples.", CardType.ANSWER),
            new Card("Active listening.", CardType.ANSWER),
            new Card("Poor life choices.", CardType.ANSWER),
            new Card("Altar boys.", CardType.ANSWER),
            new Card("My vagina.", CardType.ANSWER),
            new Card("Pac-Man uncontrollably guzzling cum.", CardType.ANSWER),
            new Card("Sniffing glue.", CardType.ANSWER),
            new Card("The placenta.", CardType.ANSWER),
            new Card("The profoundly handicapped.", CardType.ANSWER),
            new Card("Spontaneous human combustion.", CardType.ANSWER),
            new Card("The KKK.", CardType.ANSWER),
            new Card("The clitoris.", CardType.ANSWER),
            new Card("Not wearing pants.", CardType.ANSWER),
            new Card("Consensual sex.", CardType.ANSWER),
            new Card("Black people.", CardType.ANSWER),
            new Card("A bucket of fish heads.", CardType.ANSWER),
            new Card("Hospice care.", CardType.ANSWER),
            new Card("Passive-aggressive Post-it notes.", CardType.ANSWER),
            new Card("The heart of a child.", CardType.ANSWER),
            new Card("Crumbs all over the god damn carpet.", CardType.ANSWER),
            new Card("Your weird brother.", CardType.ANSWER),
            new Card("Being fat and stupid.", CardType.ANSWER),
            new Card("Getting married having a few kids, buying some stuff, retiring to Florida and dying.", CardType.ANSWER),
            new Card("Expecting a burp and vomiting on the floor.", CardType.ANSWER),
            new Card("Wifely duties.", CardType.ANSWER),
            new Card("A pyramid of severed heads.", CardType.ANSWER),
            new Card("Historically black colleges.", CardType.ANSWER),
            new Card("Donald Trump", CardType.ANSWER),
            new Card("Elon Musk", CardType.ANSWER),
            new Card("A subscription to Men's Fitness.", CardType.ANSWER),
            new Card("The milk man.", CardType.ANSWER),
            new Card("Friendly fire.", CardType.ANSWER),
            new Card("Women's suffrage.", CardType.ANSWER),
            new Card("AIDS.", CardType.ANSWER),
            new Card("Former President George W. Bush", CardType.ANSWER),
            new Card("8 oz. of sweet Mexican black-tar heroin.", CardType.ANSWER),
            new Card("Half-assed foreplay.", CardType.ANSWER),
            new Card("Edible underpants.", CardType.ANSWER),
            new Card("My collection of high-tech sex toys.", CardType.ANSWER),
            new Card("The Force.", CardType.ANSWER),
            new Card("Bees?", CardType.ANSWER),
            new Card("Some god-damn peace and quiet.", CardType.ANSWER),
            new Card("Jerking off into a pool of children's tears.", CardType.ANSWER),
            new Card("A micropig wearing a tiny raincoat and booties.", CardType.ANSWER),
            new Card("Three dicks at the same time.", CardType.ANSWER),
            new Card("Masterbation.", CardType.ANSWER),
            new Card("Tom Cruise.", CardType.ANSWER),
            new Card("A balanced breakfast.", CardType.ANSWER),
            new Card("Anal beads.", CardType.ANSWER),
            new Card("Drinking alone.", CardType.ANSWER),
            new Card("Cards Against Humanity.", CardType.ANSWER),
            new Card("Coat hanger abortions.", CardType.ANSWER),
            new Card("Used panties.", CardType.ANSWER),
            new Card("Cuddling.", CardType.ANSWER),
            new Card("Wiping her butt.", CardType.ANSWER),
            new Card("Domino's Oreo Dessert Pizza.", CardType.ANSWER),
            new Card("A zesty breakfast burrito.", CardType.ANSWER),
            new Card("Morgan Freeman's voice.", CardType.ANSWER),
            new Card("A middle-aged man on roller skates.", CardType.ANSWER),
            new Card("Gandhi.", CardType.ANSWER),
            new Card("The penny whistle solo from \"My Heart Will Go On.\"", CardType.ANSWER),
            new Card("Spectacular Abs.", CardType.ANSWER),
            new Card("Child beauty pageants.", CardType.ANSWER),
            new Card("Child abuse.", CardType.ANSWER),
            new Card("Bill Nye the Science Guy.", CardType.ANSWER),
            new Card("Science.", CardType.ANSWER),
            new Card("A tribe of warrior women.", CardType.ANSWER),
            new Card("Viagra.", CardType.ANSWER),
            new Card("Her Majesty, Queen Elizabeth II.", CardType.ANSWER),
            new Card("The entire Mormon Tabernacle Choir.", CardType.ANSWER),
            new Card("This year's mass shooting.", CardType.ANSWER),
            new Card("Take-backsies.", CardType.ANSWER),
            new Card("An erection that lasts longer than four hours.", CardType.ANSWER)
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
