package hotel3h;

/**
* Class: Room
* Usage: Class for creating Room objects.
* @author Helgi
* @author Omar
* @author Snaevar
*/

public class RoomMock {

	int nr, hnr, pets, count, washing, kitchen, minifridge, tv, bath, view, noise, smoke, ac, price, size, bed1, bed2, baby;

	public RoomMock(
                int nr,
                int hnr,
                int pets,
                int count,
                int washing,
                int kitchen,
                int minifridge,
                int tv,
                int bath,
                int view,
                int noise,
                int smoke,
                int ac,
                int price,
                int size,
                int bed1,
                int bed2,
                int baby) {
	
		this.nr = nr;
		this.hnr = hnr;
		this.pets = pets;
		this.washing = washing;
		this.kitchen = kitchen;
		this.minifridge = minifridge;
		this.tv = tv;
		this.bath = bath;
		this.view = view;
		this.noise = noise;
		this.smoke = smoke;
		this.ac = ac;
		this.price = price;
		this.size = size;
		this.bed1 = bed1;
		this.bed2 = bed2;
		this.baby = baby;
                this.count = 2*bed2 + bed1;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public int getHnr() {
		return hnr;
	}

	public void setHnr(int hnr) {
		this.hnr = hnr;
	}

	public int getPets() {
		return pets;
	}

	public void setPets(int pets) {
		this.pets = pets;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getWashing() {
		return washing;
	}

	public void setWashing(int washing) {
		this.washing = washing;
	}

	public int getKitchen() {
		return kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public int getMinifridge() {
		return minifridge;
	}

	public void setMinifridge(int minifridge) {
		this.minifridge = minifridge;
	}

	public int getTv() {
		return tv;
	}

	public void setTv(int tv) {
		this.tv = tv;
	}

	public int getBath() {
		return bath;
	}

	public void setBath(int bath) {
		this.bath = bath;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getNoise() {
		return noise;
	}

	public void setNoise(int noise) {
		this.noise = noise;
	}

	public int getSmoke() {
		return smoke;
	}

	public void setSmoke(int smoke) {
		this.smoke = smoke;
	}

	public int getAc() {
		return ac;
	}

	public void setAc(int ac) {
		this.ac = ac;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getBed1() {
		return bed1;
	}

	public void setBed1(int bed1) {
		this.bed1 = bed1;
	}

	public int getBed2() {
		return bed2;
	}

	public void setBed2(int bed2) {
		this.bed2 = bed2;
	}
	
	public int getBaby() {
		return baby;
	}

	public void setBaby(int baby) {
		this.baby = baby;
	}
        
        public int[] getAllInt(int minPrice, int maxPrice, int minSize, int maxSize){
            int[] i = {hnr, pets, washing, kitchen, minifridge, tv, bath, view, noise, smoke, ac, 
                minPrice, maxPrice, minSize, maxSize, bed1, bed2, baby};
            return i;
        }

}