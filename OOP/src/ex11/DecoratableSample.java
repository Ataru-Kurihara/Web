package ex11;

public class DecoratableSample {
   public static void main(String[] args) {
      Decoratable star, box, list, freestyle;
      star = new Star("Hello Tokyo");
      box = new Box("日本後");
      list = new List("Hello Universe", 3);
      freestyle = new FreeStyle("20FI000");
      star.decorate();
      box.decorate();
      list.decorate();
      freestyle.decorate();
   }
}
