package Amazon;

public class RectangleOverlap {
	class Node {
		int x;
		int y;
	}

	class Rect {
		Node leftTop;
		Node rightBottom;
	}
	// rectangle A, B
	// time O(1), space O(1)
	public static boolean overlap(Rect rect1, Rect rect2) {
		int rect1LeftTopX = Math.min(rect1.leftTop.x, rect1.rightBottom.x);
		int rect1LeftTopY = Math.max(rect1.leftTop.y, rect1.rightBottom.y);
		int rect1rightBottomX = Math.max(rect1.leftTop.x, rect1.rightBottom.x);
		int rect1rightBottomY = Math.min(rect1.leftTop.y, rect1.rightBottom.y);
 
		int rect2LeftTopX = Math.min(rect2.leftTop.x, rect2.rightBottom.x);
		int rect2LeftTopY = Math.max(rect2.leftTop.y, rect2.rightBottom.y);
		int rect2rightBottomX = Math.max(rect2.leftTop.x, rect2.rightBottom.x);
		int rect2rightBottomY = Math.min(rect2.leftTop.y, rect2.rightBottom.y);

		if (rect1LeftTopX > rect2rightBottomX || rect2LeftTopX > rect1rightBottomX) {
			return false;
		}
		if (rect1rightBottomY > rect2LeftTopY || rect2rightBottomY > rect1LeftTopY) {
			return false;
		}
		return true;
	}
}
