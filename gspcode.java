import java.util.*;
class gspcode2
{
    static Scanner sc=new Scanner(System.in);
    static String prompt;
    static String prompt_labelled="";
    static String trig_equalsto="";
    static String trig_alz="";
    static String flag="";
    static String Grid[][]=new String[100][100];
    static int weight[];
    static int i,j=0,k=0;
    static char ch;
    public static void main()
    {
        input();
        promptLabell();
        mathLabell();
        assignWeight();
        assignFlag();
        createGrid();
        developerPrint();
        reset();
    }
    public static void input()
    {
        System.out.println("Enter the prompt.");
        prompt=sc.nextLine().trim();
    }
    public static void promptLabell()
    {
        for(i=0;i<prompt.length();i++)
        {
            ch=prompt.charAt(i);
            if(Character.isLetter(ch)==true)
            ch='c';
            else if(Character.isDigit(ch)==true)
            ch='d';
            else if(ch==' ')
            ch='b';
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='(' || ch==')' || ch=='[' || ch==']' || ch=='{' || ch=='}')
            ch='s';
            else if(ch==',' || ch=='.' || ch==';' || ch==':' || ch=='"' || ch=='\'' || ch=='|')
            ch='p';
            else
            ch='o';
            prompt_labelled+=ch;
        }
    }
    public static void mathLabell()
    {
        for(i=0;i<prompt.length();i++)
        {
            ch=prompt.charAt(i);
            if(ch=='=')
            ch='=';
            else
            ch=' ';
            trig_equalsto+=ch;
        }
        
        for(i=0;i<prompt.length();i++)
        {
            ch=prompt.charAt(i);
            if(ch=='x')
            ch='x';
            else if(ch=='y')
            ch='y';
            else
            ch=' ';
            trig_alz+=ch;
        }
    }
    public static void assignWeight()
    {
        weight=new int[prompt.length()];
        if(prompt_labelled.charAt(0)=='s' || trig_equalsto.charAt(0)=='=' || trig_alz.charAt(0)!=' ')
            {
                weight[0]+=2;
                weight[1]+=2;
            }
            else
            {
                weight[0]-=1;
                weight[1]-=1;
            }
        for(i=1;i<prompt.length()-1;i++)
        {
            if(prompt_labelled.charAt(i)=='s' || trig_equalsto.charAt(i)=='=' || trig_alz.charAt(i)!=' ')
            {
                weight[i-1]+=2;
                weight[i]+=2;
                weight[i+1]+=2;
            }
            else
            {
                weight[i-1]-=1;
                weight[i]-=1;
                weight[i+1]-=1;
            }
        }        
        if(prompt_labelled.charAt(i)=='s' || trig_equalsto.charAt(i)=='=' || trig_alz.charAt(i)!=' ')
            {
                weight[i]+=2;
                weight[i-1]+=2;
            }
            else
            {
                weight[i]-=1;
                weight[i-1]-=1;
            }
    }
    public static void assignFlag()
    {
        for(i=0;i<prompt.length();i++)
        {
            if(weight[i]>0)
            ch='1';
            else if(weight[i]==0)
            {
                if(weight[i-1]>0 && weight[i+1]<0)
                ch='1';
                else
                ch='0';
            }
            else
            ch='0';
            flag+=ch;
        }
    }
    public static void createGrid()
    {
        for(i=0;i<100;i++)
        {
            for(k=0;k<100;k++)
            {
                Grid[i][k]="";
            }
        }
        
        int size=0,indicate=0;
        for(j=0;j<prompt.length();j++)
        {
            if(flag.charAt(j)=='1')
            {
                if(indicate>0)
                {
                size+=1;k=0;
                indicate=0;
                }
                Grid[size][k]+=prompt.charAt(j);k++;
            }
            else
            {
                indicate+=1;
                //System.out.print(Grid[k][i]+" ");
            }
        }
        if(flag.charAt(prompt.length()-1)!=0)
        {
            size+=1;
        }
    }
    public static void developerPrint()
    {
        System.out.println(prompt_labelled);
        System.out.println(trig_equalsto);
        System.out.println(trig_alz);
        for(i=0;i<prompt.length();i++)
        {
            System.out.print(weight[i]);
        }
        System.out.println();
        System.out.println(flag);
        for(i=0;i<100;i++)
        {
            for(k=0;k<100;k++)
            {
                System.out.print(Grid[i][k]);
            }
            System.out.println();
        }
    }
    public static void reset()
    {
        prompt_labelled="";
        trig_equalsto="";
        trig_alz="";
        flag="";
        for(i=0;i<100;i++)
        {
            for(k=0;k<100;k++)
            {
                Grid[i][k]="";
            }
        }
        for(i=0;i<prompt.length();i++)
        {
            weight[i]=0;
        }
        i=j=k=0;
        prompt="";
    }
}