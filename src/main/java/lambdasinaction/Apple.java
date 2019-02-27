package lambdasinaction;

public class Apple {
	
	private Integer weight;
	private String color;
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}

}
