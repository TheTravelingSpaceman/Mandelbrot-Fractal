public class ComplexNumber{
   public double real;
   public double lateral;

   public ComplexNumber(double real, double lateral){
      this.real = real;
      this.lateral = lateral;
   }

   public ComplexNumber add(ComplexNumber other){
      return new ComplexNumber(this.real + other.real, this.lateral + other.lateral);
   }

   public double getAbsolute(){
      return Math.sqrt(real*real + lateral*lateral);
   }

   public ComplexNumber getSquare(){
      return new ComplexNumber(real*real-lateral*lateral,2*real*lateral);
   }

   public static ComplexNumber func(ComplexNumber seed, ComplexNumber par){
      ComplexNumber i = par.getSquare();
      i = i.add(seed);
      return i;
   }
}
