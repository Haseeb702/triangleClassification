package com.company;
import java.awt.*; 
import javax.swing.JFrame;

class TriangleClassification extends Canvas
{
 
  @Override
  public void paint(Graphics g) 
  {
    Toolkit t=Toolkit.getDefaultToolkit();
    Image i=t.getImage(imageName);
    g.drawImage(i, 60,40,this);    
  }
  
  private String imageName; 
  TriangleClassification(String imageName) 
  {
    this.imageName = imageName;
  }
  
  
  public static int min (int a, int b)
  {
    int minimum;
    
    if (a < b)
    {
      minimum = a;
    }
    else
    {
      minimum = b;
    }
    return minimum;
  }
  
  public static int min (int a, int b, int c)
  {
    int temp = min(a, b);
    return min(temp, c);
  }
  
  public static int max (int a, int b)
  {
    int maximum;
    
    if (a > b)
    {
      maximum = a;
    }
    else
    {
      maximum = b; 
    }
    return maximum;
  }
  
  public static int max ( int a, int b, int c)
  {
    int temp = max(a, b);
    return max(temp, c);
  }
  
  
  public static int mid ( int a, int b, int c )
  {
    if ((a < b && b < c) || (c < b && b < a))
    {
      return b;
    } 
    
    else if ((b <= a && a < c) || (c < a && a <= b))
    {
      return a;
    }
    else
    {
      return c;
    }
  }
  
  public static boolean isFinished ( int a, int b, int c )
  {
    if (a == 0 && b == 0 && c == 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public static boolean invalidNum (int a, int b, int c)
  {
    if (a == 0 && b == 0 && c == 0)
    {
      return false;
    }
    else if (a <= 0 || b <= 0 || c <= 0)
    {
      return true;
    }
    else if ((a == 1 && b > 1 && c >= 1) || (a >= 1 && b == 1 && c > 1) || (a > 1 && b >= 1 && c == 1))
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
  public static String sideCheck (int a, int b, int c)
  {
    if (a == b && a == c && b == c)
    {
      return "equilateral";
    }
    else if (a != b && a != c && b != c)
    {
      return "scalene";
    }
    else
    {
      return "isosceles";
    }
  }
  
  public static String angleCheck(int a, int b, int c)
  {
    if (Math.pow(max(a, b, c), 2) == Math.pow(min(a, b, c), 2) + Math.pow(mid(a, b, c), 2))
    {
      return "right";
    }
    else if (Math.pow(max(a, b, c), 2) > Math.pow(min(a, b, c), 2) + Math.pow(mid(a, b, c), 2))
    {
      return "obtuse"; 
    }
    else
    {
      return "acute"; 
    }
  }  
  
  public static double angleA (int a, int b, int c)
  {
    double angleA =  Math.toDegrees(Math.acos((b * b + c * c - a * a)/(2.0 * b * c))); 
    return Math.round(angleA);
  }
  
  public static double angleB (int a, int b, int c)
  {
    double angleB =  Math.toDegrees(Math.acos((a * a + c * c - b * b)/(2.0 * a * c)));
    return Math.round(angleB);
  }
  
  public static double angleC (int a, int b, int c)
  {
    double angleC = 180 - (angleB(a, b, c) + angleA(a, b, c));
    return angleC;
  }
  
  public static int perimeter (int a, int b, int c)
  {
    return a + b + c;
  }
  
  public static double area (int a, int b, int c)
  {
    double s = (perimeter(a, b, c))/2.0;
    double areaVal = Math.sqrt(s*(s-a)*(s-b)*(s-c)) * 100 /100;
    return areaVal;
  }
  
  public static void displayValues ( int a, int b, int c )
  {  
    System.out.println(a + " " + b + " " + c + " Triangle possible: " + sideCheck(a, b, c) + " and " + angleCheck(a, b, c));
    System.out.println("Angle A: " + angleA(a, b, c));
    System.out.println("Angle B: " + angleB(a, b, c));
    System.out.println("Angle C: " + angleC(a, b, c));
    System.out.println("The perimeter is: " + perimeter(a, b, c) + " units");
    System.out.printf("The area is: %.2f", area(a, b, c));
    System.out.println(" units squared");
    
    if (sideCheck(a, b, c).equals("equilateral"))
    {
      TriangleClassification m = new TriangleClassification("equaliso.png");
      JFrame f = new JFrame();
      f.add(m);
      f.setSize(400,400);
      f.setVisible(true);
    }
  }
  
  public static void main (String[] args)
  {
    int x, y, z;
    System.out.println("Yay! it pushed!");
    do
    {
      System.out.println("Provide three side lengths - 0 0 0 to terminate");
      x = In.getInt();
      y = In.getInt();
      z = In.getInt();
      System.out.println("\nSide 1: " + x + " units" + "\nSide 2: " + y +  " units" + "\nSide 3: " + z + " units");
      
      if (invalidNum(x, y, z))
      {
        
        System.out.println(x + " " + y + " " + z + " Triangle can not be formed");
      }
      else if (isFinished(x,y,z))
      {
        System.out.println("0 0 0 Program was terminated by user.");
      }
      else
      {
        displayValues(x, y, z);
      }
    } while (!isFinished(x,y,z));
    
  }
}

