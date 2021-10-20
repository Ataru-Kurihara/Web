package chap12.list12_05;

class NamedRectangle extends Rectangle {
    String name;
    NamedRectangle() {
        // ここ
        name = "NO NAME";
    }
    NamedRectangle(String name) {
        // ここ
        this.name = name;
    }
}
