package Math;

public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int blx = Math.max(A, E);  
        int bly = Math.max(B, F);  
        int rtx = Math.min(C, G);  
        int rty = Math.min(D, H);  
        int res = (C-A) * (D-B) + (G-E) * (H-F);  
        if(blx >= rtx || bly >= rty) return res;  
        return res - (rtx - blx) * (rty - bly);  
		
	}
	public static void main(String[] args) {
		System.out.println(computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}
}
