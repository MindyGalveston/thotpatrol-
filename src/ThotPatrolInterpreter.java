


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Mindy on 1/13/2017.
 */
public class ThotPatrolInterpreter {

    private static int OPEN_IF_FLAG = 666;
    private  static int OPEN_WHILE_FLAG = 420;

public static void main(String[] args)
{

    StateSystem s = new StateSystem();
    initializeNameTable(s.nameUtilization);
    runProgram(args[0],s);
}

public static void runProgram(String programFile,StateSystem s )
{
    try {
        StateSystem internal = new StateSystem();
        internal.thots = s.thots;
        internal.thaughties = s.thaughties;
        internal.thotties = s.thotties;
        internal.nameUtilization = s.nameUtilization;
        Scanner fileScan =  new Scanner(new File(programFile),"UTF-16");
        String file =  "";
        while (fileScan.hasNextLine())
        {

          file = file + fileScan.nextLine() + "\n";
        }
        file = tokenizeLiterals(file);
        fileScan.close();
        String[] lines = file.split("\\r?\\n");
        String[] program = noComment(lines);
        resolveFlowStructure(program,internal.jumpIndices);
      try   {
            while (internal.pointer < program.length) {
                execute(program[internal.pointer], internal);
                internal.pointer++;
            }
       }catch(Exception E)
        {
            throw new CompilationException("syntax error on line: " + Integer.toString(internal.pointer) + "\n" + lines[s.pointer]);
        }



    }
    catch (FileNotFoundException E)
    {
        System.out.println("FILE NOT FOUND");
    }
    catch (NoSuchElementException E)
    {
        System.out.println("READ FAILED");
    }
}









private static String[] noComment(String[] lines)
{
    int startPointer = -1;
    int endPointer = -1;
    for (int i = 0; i < lines.length; i ++ )
    {
        if(lines[i].contains("\uD83D\uDD25")) lines[i] = lines[i].substring(0,lines[i].indexOf("\uD83D\uDD25"));
        if(lines[i].trim().equals("\uD83D\uDCE1JACKING IN\uD83D\uDCE1")) startPointer = i;
        if(lines[lines.length-i-1].contains("\uD83D\uDD25"))lines[lines.length-1-i] = lines[lines.length-1-i].substring(0,lines[lines.length-1-i].indexOf("\uD83D\uDD25"));
        if(lines[lines.length-1-i].trim().equals("\uD83C\uDDFA\uD83C\uDDF8REPORT UNPATRIOTIC ACTIVITY\uD83C\uDDFA\uD83C\uDDF8")) endPointer = lines.length-1-i;

    }
    if (startPointer == -1 || endPointer == -1 || startPointer >= endPointer)
    {

        throw new CompilationException("Missing correct File Opener/Closer" );
    }
    return Arrays.copyOfRange(lines,startPointer,endPointer);
}

private static void resolveFlowStructure(String[] program, Hashtable<Integer, Integer> jumpIndices)
{
    ArrayList<Integer> referenceStack = new ArrayList<>();
    ArrayList<Integer> typeStack = new ArrayList<>();
    for (int i = 0; i <  program.length; i++)
    {
        String[] commands = program[i].split("\\s+");
        if(commands[0].equals("\uD83D\uDE0EBRIEF\uD83D\uDE0E"))
        {
            referenceStack.add(i);
            typeStack.add(OPEN_IF_FLAG);
        }
        else if(commands[0].equals("❤PRIME") && commands[1].equals( "ASSETS❤"))
        {
            referenceStack.add(i);
            typeStack.add(OPEN_WHILE_FLAG);
        }
        else if(commands[0].equals("\uD83D\uDD07DEBRIEF\uD83D\uDD07"))
        {

            try
            {
                int type = typeStack.get(typeStack.size()-1);
                if(type == OPEN_IF_FLAG)
                {
                    int index = referenceStack.remove(referenceStack.size()-1);
                    typeStack.remove(typeStack.size()-1);
                    jumpIndices.put(index,i);
                    jumpIndices.put(i, index);
                }
                else throw new CompilationException("syntax error on line: "+ i );

            }
            catch (ArrayIndexOutOfBoundsException E)
            {
                throw new CompilationException("syntax error on line: "+ i );
            }
        }
        else if(commands[0].equals("\uD83C\uDFA7INTERCEPT") && commands[1].equals("MALIGNANT") && commands[2].equals("COMMUNICATIONS\uD83C\uDFA7"))
        {

            try
            {
                int type = typeStack.get(typeStack.size()-1);
                if(type == OPEN_WHILE_FLAG)
                {
                    int index = referenceStack.remove(referenceStack.size()-1);
                    typeStack.remove(typeStack.size()-1);
                    jumpIndices.put(index,i);
                    jumpIndices.put(i, index);
                }
                else throw new CompilationException("syntax error on line: "+ i );

            }
            catch (ArrayIndexOutOfBoundsException E)
            {
                throw new CompilationException("syntax error on line: "+ i );
            }
        }
    }


}

public static void execute( String command, StateSystem s) {

    String[] ignoreTable = {"📡JACKING", "\uD83D\uDD07DEBRIEF\uD83D\uDD07","🇺🇸REPORT"};
    for (String string : ignoreTable)
    {
        if( command.contains(string))
        {
            return;
        }
    }
    String[] tokens = command.split("\\s+");
    if(tokens[0].equals(""))return;
    if (tokens[0].equals("\uD83E\uDD37"))
    {
        try {
            execute(command.replaceFirst(Pattern.quote("\uD83E\uDD37"), ""), s);
        }
        catch (Exception E)
        {

        }
        return;
    }
    switch (tokens[0]) {
        case("\uD83D\uDCA6DM\uD83D\uDCA6"):
            if (tokens[1].equals("THAUGHTY")) {

                String name = (String)evaluateValue(Arrays.copyOfRange(tokens,2,tokens.length),s);
                if (!s.nameUtilization.containsKey(name)) {
                    s.nameUtilization.put(name, true);
                    s.thaughties.put(name, "");
                }
                else
                {
                    throw new CompilationException("syntax error on line: "+ s.pointer);
                }
            } else if (tokens[1].equals("THOTTY")) {
                String name = (String)evaluateValue(Arrays.copyOfRange(tokens,2,tokens.length),s);

                if (!s.nameUtilization.containsKey(name)) {
                    s.nameUtilization.put(name, true);
                    s.thotties.put(name, 0);
                }
                else
                {
                    throw new CompilationException("syntax error on line: "+ s.pointer);
                }
            } else if (tokens[1].equals("THOT")) {
                String name = (String)evaluateValue(Arrays.copyOfRange(tokens,2,tokens.length),s);
                if (!s.nameUtilization.containsKey(name)) {
                    s.nameUtilization.put(name, true);
                    s.thots.put(name, false);
                }
                else
                {
                    throw new CompilationException("syntax error on line: "+ s.pointer);
                }
            } else {
                throw new CompilationException("syntax error on line: "+ s.pointer );
            }
            break;
        case("\uD83D\uDD75") :
            if(tokens[1].equals("\uD83D\uDCE7\uD83C\uDF46") && s.nameUtilization.get(tokens[2]))
            {
                if(s.thaughties.containsKey(tokens[2])) {
                Scanner sc = new Scanner(System.in);
                s.thaughties.put(tokens[2],sc.nextLine().toUpperCase());
                }
                else if (s.thotties.containsKey(tokens[2]))
                {
                    Scanner sc = new Scanner(System.in);
                    s.thotties.put(tokens[2],Integer.parseInt(sc.nextLine()));
                }
                else if (s.thots.containsKey(tokens[2]))
                {
                    Scanner sc = new Scanner(System.in);
                    s.thots.put(tokens[2],Boolean.parseBoolean(sc.nextLine()));
                }
                else
                {
                    throw new CompilationException("syntax error on line: "+ s.pointer );
                }
            }
            else if(tokens[1].equals("\uD83C\uDF51\uD83D\uDCE7"))
            {
                System.out.print(evaluateValue(Arrays.copyOfRange(tokens, 2, tokens.length),s));
            }
            break;
        case("\uD83D\uDE0EBRIEF\uD83D\uDE0E") :
            if (!(Boolean) evaluateValue(Arrays.copyOfRange(tokens,1,tokens.length),s))
            {
                s.pointer = s.jumpIndices.get(s.pointer);
            }
            break;
        case("❤PRIME") :
            if (tokens[1].equals("ASSETS❤"))
            {
                if (!(Boolean) evaluateValue(Arrays.copyOfRange(tokens,2,tokens.length),s))
                {
                    s.pointer = s.jumpIndices.get(s.pointer);
                }

            }
            else throw new CompilationException("syntax error on line: "+ s.pointer);
        break;
        case("🎧INTERCEPT") :

            if (tokens[1].equals("MALIGNANT") && tokens[2].equals("COMMUNICATIONS🎧"));
            {

               s.pointer = s.jumpIndices.get(s.pointer)-1;

            }
            break;

        case ("NAUGHTY") :
            if(tokens.length == 3) {
                switch (tokens[1]) {
                    case ("THOTTY") :
                        if (s.thotties.containsKey(tokens[2]))
                        {
                            s.thotties.remove(tokens[2]);
                            s.nameUtilization.put(tokens[2], false );
                        }
                        else throw new CompilationException("syntax error on line: " + s.pointer);
                    break;
                    case ("THOT") :
                        if (s.thots.containsKey(tokens[2]))
                        {
                            s.thots.remove(tokens[2]);
                            s.nameUtilization.put(tokens[2], false );
                        }
                        else throw new CompilationException("syntax error on line: " + s.pointer);
                        break;
                    case ("THAUGHTY") :
                        if (s.thaughties.containsKey(tokens[2]))
                        {
                            s.thaughties.remove(tokens[2]);
                            s.nameUtilization.put(tokens[2], false );
                        }
                        else throw new CompilationException("syntax error on line: " + s.pointer);
                        break;
                }
            }
            else
            {
                throw new CompilationException("syntax error on line: "+ s.pointer);
            }
            break;
        case("\uD83D\uDC50"):
                int temp = s.pointer;
                runProgram(tokens[1], s);
                s.pointer = temp;

            break;
            default:
                try
                {
                    if(!s.nameUtilization.get(tokens[0]))
                    {
                        throw new CompilationException("syntax error on line: "+ s.pointer );
                    }
                    if(s.thaughties.containsKey(tokens[0]))
                    {
                        if (tokens[1].equals("\uD83C\uDF51\uD83D\uDCE7"))
                        {

                                s.thaughties.put(tokens[0], (String)evaluateValue(Arrays.copyOfRange(tokens,2,tokens.length),s));

                        }

                    }
                    else if (s.thotties.containsKey(tokens[0]))
                    {
                        if (tokens[1].equals("\uD83C\uDF51\uD83D\uDCE7")) {

                            s.thotties.put(tokens[0], (int) evaluateValue(Arrays.copyOfRange(tokens, 2, tokens.length), s));

                        }
                    }
                    else if (s.thots.containsKey(tokens[0]))
                    {
                        if (tokens[1].equals("\uD83C\uDF51\uD83D\uDCE7"))
                        {
                           s.thots.put(tokens[0],(boolean)evaluateValue(Arrays.copyOfRange(tokens, 2, tokens.length), s));
                        }

                    }


                }
                catch (NullPointerException E)
                {
                    throw new CompilationException("syntax error on line: "+ s.pointer );
                }
        }

}

public static void initializeNameTable(Hashtable<String, Boolean> table)
{
    try{
        String file = new Scanner(new File("thotNames.txt"),"UTF-16").useDelimiter("\\Z").next();
        String[] lines = file.split("\r\n");
    for(String s : lines )
    {
    table.put(s, false);
    }}catch ( Exception E)
    {
        System.out.println("NAME FILE READ FAILED");
    }

}

     public static Object evaluateValue(String tokens[], StateSystem s) {


         if (tokens.length % 2 == 0) {

             throw new CompilationException("syntax error on line: "+ s.pointer );

         }
         if (tokens.length == 1) {
             if (s.thotties.containsKey(tokens[0])) {
                 return s.thotties.get(tokens[0]);
             } else if (s.thaughties.containsKey(tokens[0])) {
                 return s.thaughties.get(tokens[0]);
             } else if (s.thots.containsKey(tokens[0])) {
                 return s.thots.get(tokens[0]);
             } else if (tokens[0].startsWith("™") && tokens[0].endsWith("™")) {
                 return Integer.parseInt(tokens[0].substring(1, tokens[0].length() - 1));
             } else if (tokens[0].startsWith("©") && tokens[0].endsWith("©")) {
                 return detokenizeLiteral((tokens[0].substring(1, tokens[0].length() - 1)));
             } else if (tokens[0].startsWith("\uD83D\uDE43")) {
                 String[] val = {tokens[0].replace("\uD83D\uDE43", "")};
                 return (!(boolean)evaluateValue(val,s));
             } else if (tokens[0].equals("\uD83C\uDE51")) {
                 return true;
             } else if (tokens[0].equals("\uD83C\uDE32")) {
                 return false;
             } else throw new CompilationException("syntax error on line: "+ s.pointer );

         }

         int index;

          if ((index = containsToken("INFORMANT", tokens))!=-1)
         {
             return (boolean)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) || (boolean)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);

         }
         else if ((index = containsToken("CONSPIRATOR", tokens))!=-1) //and
         {
             return (boolean)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) && (boolean)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);

         }
         else if ((index = containsToken("INTERROGATE", tokens))!=-1)
         {
             return evaluateValue(Arrays.copyOfRange(tokens,0,index),s).equals(evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s));

         }
          else if ((index = containsToken("\uD83D\uDC49", tokens))!=-1)
          {
              return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) > (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);

          }
          else if ((index = containsToken("\uD83D\uDC48", tokens))!=-1)
          {
              return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) < (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);

          }
          else if ((index = containsToken("\uD83E\uDD1C", tokens))!=-1)
          {
              return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) >= (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);

          }
          else if ((index = containsToken("\uD83E\uDD1B", tokens))!=-1)
          {
              return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) <= (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);

          }
         else if ((index = containsToken("\uD83D\uDE02", tokens))!=-1)
         {
             return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) % (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);
         }
         else if ((index = containsToken("\uD83D\uDD96", tokens))!=-1)
         {
             return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) / (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);
         }
         else if ((index = containsToken("\uD83D\uDC6A", tokens))!=-1)
         {
             return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) * (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);
         }
         else if ((index = containsToken("\uD83D\uDC7B", tokens))!=-1)
         {
             return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) - (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);
         }
         else if ((index = containsToken("\uD83D\uDC4F", tokens))!=-1)
         {
             return (int)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) + (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);
         }
         else if ((index = containsToken("REDACTED", tokens))!=-1)
          {
              return (String)evaluateValue(Arrays.copyOfRange(tokens,0,index),s) + (String)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s);
          }
          else if ((index = containsToken("\uD83D\uDD0E", tokens))!=-1)
          {
              char temp = ((String)evaluateValue(Arrays.copyOfRange(tokens,0,index),s)).charAt( (int)evaluateValue(Arrays.copyOfRange(tokens,index+1,tokens.length),s));
              String output = "";
              output = output + temp;
              return output;
          }
         else throw new CompilationException("syntax error on line: "+ s.pointer );
     }


    public static int containsToken(String token, String[] tokens)
    {
        for (int i = 0; i < tokens.length; i ++)
        {
            if (tokens[i].equals(token)) return i;
        }
        return -1;
    }

    public static String tokenizeLiterals(String source)
    {
        boolean literal = false;
        String output = "";
        for  (int i = 0 ; i < source.length(); i++)
        {
            if(source.charAt(i) == '©')
            {
                literal = !literal;
            }
            if(source.charAt(i) == ' ' && literal)
            {
                output = output + "token_SPACE";
            }
            else if((source.charAt(i) == '\n' ||source.charAt(i) == '\r') && literal)
            {
                output = output + "token_NEWLINE";
            }
            else
            {
                output = output + source.charAt(i);
            }
        }
        return output;
    }
    public static String detokenizeLiteral(String literal)
    {
        String output = literal.replace("token_SPACE", " ");
         output = output.replace("token_NEWLINE","\n");
         return output;

    }


}


