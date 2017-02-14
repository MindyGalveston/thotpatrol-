


thotpatrol 1.0
タトパトツル


WARNING
To ensure this program continues to work, please leave thotNames.txt in
in the same directory as the executable. It contains a list of allowed variable names.
It may be modified; to comply with the thotpatrol style, only female names
may be included in the list.
WARNING
______________________________________________________________________________________________________________

Let's get programming!

First, make a new text file using notepad in the same directory as the thotpatrol executable. Save this
textfile, and make absolutely sure the encoding is UNICODE. 

You need to start the code part of the file with 📡JACKING IN📡 on a line by itself 
Similarly, you need to end the code part of the file with 🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸 on a line by itself.
Anything before or after these lines will be ignored by the interpreter.
A sample program might look like this. 
_______________________________________________________________________________________________________________

Chicken Man
2/7/annodomini2017
seems to be a program of some sort

📡JACKING IN📡
<some code here>
🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸


_________________________________________________________________________________________________________________

Now that we can make a program that will sucessfully be interpreted, lets actually make a program! We'll start with hello 
world for simplicity's sake!

In order to print a value, you're going to need to make a print statement. In thotpatrol, a print statement looks
like the following

🕵 🍑📧 <literal or expression>

🕵 represents IO , while 🍑📧 represents the assignment. You can assign a literal or a variable to the IO. As we haven't
learned how to make variables yet, were going to use a literal String(the type is called thaughty in thotpatrol).

In thotpatrol thaughy(String) literals are encapsulated by © characters. My name for example would be ©Chicken_Man©.
Note that whitespace is disallowed in thaughties(Strings).

The following program will also print Hello_world!
_______________________________________________________________________________________________________________

Chicken Man
2/7/annodomini2017
Prints Hello World!

📡JACKING IN📡
🕵 🍑📧 ©Hello_world!© 
🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸
_________________________________________________________________________________________________________________

now that we know how to print a value, let's look at the types of variable thotpatrol supports. In total, 
there are three types, all treated as primitives.

THOTTY (integer)
THAUGHTY (String)
THOT(boolean)

to set a variable name to a instance of a given type, type the following line of code:
💦DM💦 <type> ©<variablename>©

Below is an example of a thaughty declaration

💦DM💦 THAUGHTY ©LAUREN©

Below is a diagram showing the literal syntax for the various formats

THOTTY literal: ™123™
THAUGHTY literal: ©someString©
THOT literal: 🉑,🈲 (true and false respectively)

remember that the variable name must be a valid list from thotnames.txt.
all types and valid variable names must be capitalized. Below is a modified "Hello World" using a 
thaughty variable instead of a thaughty literal. 
_______________________________________________________________________________________________________________

Chicken Man
2/8/annodomini2017
Prints Hello World!

📡JACKING IN📡
💦DM💦 THAUGHTY ©KAREN©
KAREN 🍑📧 ©Hello_world!© 
🕵 🍑📧 KAREN
🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸
_________________________________________________________________________________________________________________
 


now that we understand variables, lets take a look at the binary operators offerec by thotpatrol.
thotpatrol 1.0 does not contain any unary operators.

The order of prescedence of operators is as follows:

SYMBOL          OPERATION    RETURN TYPE

INFORMANT       or           THOT
CONSPIRATOR     and          THOT
INTERROGATE     ==           Arguments must be of same type. Works for THOT and THAUGHTY equivalence.
👉               >            THOTTY
👈               <            THOTTY
🤜               >=           THOTTY
🤛               <=           THOTTY
👪               *	     THOTTY
🖖               /            THOTTY
👏               +            THOTTY
👻               -            THOTTY
😂               %            THOTTY
REDACTED        concat       THAUGHTY
🔎               charat       THAUGHTY

There is no grouping operator, so grouping against order of operations should be specified using THOT
variables to hold components of the statement. For example:

the statement a or b == c and d wilbe evaluated by the interpreter as  a or ((b ==c)and d).
The following code fragment will grant the the desired interpretation of (a or b) == (c and d)
__________________________________________________________________________________________________________


💦DM💦 THOT ©AMANDA©
💦DM💦 THOT ©BETHANY©
💦DM💦 THOT ©EMILY© 
AMANDA 🍑📧 <valuea> INFORMANT <valueb>
BETHANY 🍑📧 <valuec> CONSPIRATOR <valued>
EMILY 🍑📧 AMANDA INTERROGATE BETHANY
________________________________________________________________________________________________________

The value of the desired multi-component predicate will be stored in the THOT variable Emily. 

WARNING
THOT variables only can be directly assigned boolen values! They will not save logic statements!
This means that every time you evaluate a multi-component predicate in this manner, you must again assign
each THOT variable with the desired predicate statement. 
WARNING



Next lets talk about flow control! Thot patrol supports both looping and if then statements. Below are 
the formats for each type of statement.

❤PRIME ASSETS❤ <THOT value>
<loop contents>
🎧INTERCEPT MALIGNANT COMMUNICATIONS🎧

😎BRIEF😎 <THOT value>
<if statement contents>
🔇DEBRIEF🔇


Now that we know how to make each kind of statements, we're going to make a fizbuzz program!
This will require in some places working around the eccentricies to thotpatrol, but won't worry! It's 
possible!

In addtion, this program will contain some inline comments. You can start an inline comment with the
🔥 character. Everything else after the 🔥 character will be ignored

Here is a program which successfully implements fizzbuzz

_______________________________________________________________________________________________________________

Chicken Man
2/11/annodomini2017
A simple fizzbuzz program

"Write a program that prints the numbers from 1 to 100. But for
multiples of three print “Fizz” instead of the number and for
 the multiples of five print “Buzz”. For numbers which are multiples
 of both three and five print “FizzBuzz”."

📡JACKING IN📡

💦DM💦 THOTTY ©CHRISTINE© 🔥 var declarations
💦DM💦 THOT ©ALEXIS©
💦DM💦 THOT ©ANNA©

CHRISTINE 🍑📧 ™1™ 🔥 counter initialization

❤PRIME ASSETS❤ CHRISTINE 🤛 ™100™

ALEXIS 🍑📧 CHRISTINE 😂 ™3™ INTERROGATE ™0™ 🔥 case logic component assignment
ANNA 🍑📧 CHRISTINE 😂 ™5™ INTERROGATE ™0™

😎BRIEF😎 ALEXIS CONSPIRATOR ANNA 🔥 case logic for fizzbuzz
🕵 🍑📧 ©FizzBuzz ©
🕵 🍑📧 CHRISTINE
🕵 🍑📧 ©
©
🔇DEBRIEF🔇
😎BRIEF😎 ALEXIS CONSPIRATOR 🙃ANNA
🕵 🍑📧 ©Fizz ©
🕵 🍑📧 CHRISTINE
🕵 🍑📧 ©
©
🔇DEBRIEF🔇
😎BRIEF😎 🙃ALEXIS CONSPIRATOR ANNA
🕵 🍑📧 ©Buzz ©
🕵 🍑📧 CHRISTINE
🕵 🍑📧 ©
©
🔇DEBRIEF🔇
😎BRIEF😎 🙃ALEXIS CONSPIRATOR 🙃ANNA
🕵 🍑📧 CHRISTINE
🕵 🍑📧 ©
©
🔇DEBRIEF🔇

CHRISTINE 🍑📧 CHRISTINE 👏 ™1™ 🔥 counter incrementation

🎧INTERCEPT MALIGNANT COMMUNICATIONS🎧



🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸

_________________________________________________________________________________________________________________
 

This program provides representative example of conditional logic and iteration available in thot patrol.


In addition to iteration, thot patrol supports recursion, although it does not allow the formal 
definition of functions. 

👐 <programFileName> will open and execute a file using as thotpatrol code. Variables from caller functions
will retain their definition and value in the callee. When the callee is done executing, control is returned to
the caller, and execution continues from where it left off. Files can recursively call themselves, and
I will now demonstrate this technique in a recursive counting program. 

________________________________________________________________________________________________________
filename: main.txt
Chicken Man
2/11/annodomimi2017

A simple recursive counting program. Will display a countdown from 123 to 1.
Main method

📡JACKING IN📡

💦DM💦 THOTTY ©KAREN©

KAREN 🍑📧 ™123™

👐 call.txt
🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸
________________________________________________________________________________________________________

filename: call.txt
Chicken Man
2/11/annodomimi2017

A simple recursive counting program. Will display a countdown from 123 to 1.
recursive method

📡JACKING IN📡


🕵 🍑📧 KAREN
🕵 🍑📧 © ©
KAREN 🍑📧 KAREN 👻 ™1™

😎BRIEF😎 KAREN 👉 ™0™
👐 call.txt
🔇DEBRIEF🔇

🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸
________________________________________________________________________________________________________

Recursion works smoothly, but as thot patrol does not have explicit function parameters,
it is up for the caller and the callee to agree on what variable each should modify.


placing 🤷 gargabasjfshkdf before a line will prevent the program from crashing if the code fails or is 
improperly formed. This is very important for trial and error variable declaration, something which will 
be necesarry for diy array implementations.You have to create code to programatically guess valid 
names of variables. This is where thotpatrol really gets esoteric! I promise this isn't just a weirdlang
The final release will have some included functions of this sort, and I will cover this in the next guide.


To complete the thotpatrol beginner intro, here is a program implementing the charat (🔎) operator.
The correct pattern is <thaughty var or literal> 🔎 <lookupIndex>
_________________________________________________________________________________________________________
📡JACKING IN📡

💦DM💦 THAUGHTY ©KAREN©


KAREN 🍑📧 ©qwerty©

🕵 🍑📧 KAREN 🔎 ™2™ 🔥 gets char at index 2 

 🇺🇸REPORT UNPATRIOTIC ACTIVITY🇺🇸


_________________________________________________________________________________________________________


