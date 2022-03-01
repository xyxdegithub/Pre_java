
public class GongYueShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GongYueShu g=new GongYueShu();
        g.gcd(12, 24);
	}
	public   int gcd(int p,int q) {
		
		if(q==0){
       System.out.println(p); }
		if(q!=0) {
			int r=p%q;
			System.out.println(r);
			p=q;
			q=r;
		}
		return 0;
    }

}
