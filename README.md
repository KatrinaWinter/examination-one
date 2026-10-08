

1. Datasäkerhet / Inkapsling
Jag har gjort owner, balance och history private i Account, så
att man inte kan gå in och ändra informationen direkt från till 
exempel Main. Istället måste man använda metoder som getBalance(), 
deposit() och withdraw(), där jag kan bestämma vad som är tillåtet. 
Om balance hade varit public skulle man till exempel kunna ändra 
saldot direkt med balance += 90000, utan att reglerna i Account 
kontrollerades.

2. Skapande-mönster / Factory
Kontot skapas via AcountRegister eftersom registret har ansvar 
för alla skapade konton och håller dem i sin ArrayList. Main 
skickar bara informationen vidare till regisret, och registret 
skapar kontot och lägger det i listan. På så sätt blir Main mindre 
rörig och det blir tydligare vilken klass som ansvarar för att skapa 
och hålla reda på kontona.

3. Flöde
Jag har insättning som exempel. Användaren väljer insättning och 
skriver sitt namn, sedan använder Main findAccount() för att hitta 
rätt konto i AccountRegister. När kontot hittas skickas beloppet till 
deposit() i Account, där beloppet kontrolleras och saldot uppdateras 
om insättningen är giltig. Därefter går programmet tillbaka till 
Main och skriver ut det nya saldot. 

4. Reflektion
I början använde jag både kursmaterialet och AI för att strukturera 
projektet och komma igång. Jag behövde bryta ner uppgiften i mindre 
och mer görbara steg, så att den inte kändes för överväldigande. När 
jag använde AI försökte jag främst fråga hur jag borde tänka och 
varför något fungerade/inte fungerade, istället för att bara be om 
färdig kod. Sedan testade jag själv i IntelliJ och försökte förstå 
och lösa problemen utifrån det jag har lärt mig. Ett exempel är när 
jag arbetade med try/catch, där jag fick förstå hur felaktig inmatning 
kunde hanteras utan att programmet kraschade.
