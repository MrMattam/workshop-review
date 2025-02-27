package fr.mbonnot;

class TemperatureConverter {

  public float celsius;
  public float fahrenheit;

  public TemperatureConverter(float value, boolean isCelsius) {
    if (isCelsius) {
      this.celsius = value;
      this.fahrenheit = (value * 9 / 5) + 32;
    } else {
      this.fahrenheit = value;
      this.celsius = (value - 32) * 5 / 9;
    }
  }

  public void display() {
    System.out.println("Celsius: " + celsius + ", Fahrenheit: " + fahrenheit);
  }

  public static void main(String[] args) {
    TemperatureConverter converter = new TemperatureConverter(100, true);
    converter.display();
    TemperatureConverter converter2 = new TemperatureConverter(32, false);
    converter2.display();
  }
}
