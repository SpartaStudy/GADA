package com.maple.mapleservice.util;

import lombok.Getter;

@Getter
public class HexaCoreTable {
	private final int[][] skill_core = new int[][] {
		{0, 0}, {1, 30}, {1, 35}, {1, 40}, {2, 45},
		{2, 50}, {2, 55}, {3, 60}, {3, 65}, {10, 200},
		{3, 80}, {3, 90}, {4, 100}, {4, 110}, {4, 120},
		{4, 130}, {4, 140}, {4, 150}, {5, 160}, {15, 350},
		{5, 170}, {5, 180}, {5, 190}, {5, 200}, {5, 210},
		{6, 220}, {6, 230}, {6, 240}, {7, 250}, {20, 500}
	};

	private final int[][] mastery_core = new int[][] {
		{3, 50}, {1, 15}, {1, 18}, {1, 20}, {1, 23},
		{1, 25}, {1, 28}, {2, 30}, {2, 33}, {5, 100},
		{2, 40}, {2, 45}, {2, 50}, {2, 55}, {2, 60},
		{2, 65}, {2, 70}, {2, 75}, {3, 80}, {8, 175},
		{3, 85}, {3, 90}, {3, 95}, {3, 100}, {3, 105},
		{3, 110}, {3, 115}, {3, 120}, {4, 125}, {10, 250}
	};

	private final int[][] enhance_core = new int[][] {
		{4, 75}, {1, 23}, {1, 27}, {1, 30}, {2, 34},
		{2, 38}, {2, 42}, {3, 45}, {3, 49}, {8, 150},
		{3, 60}, {3, 68}, {3, 75}, {3, 83}, {3, 90},
		{3, 98}, {3, 105}, {3, 113}, {4, 120}, {12, 263},
		{4, 128}, {4, 135}, {4, 143}, {4, 150}, {4, 158},
		{5, 165}, {5, 173}, {5, 180}, {6, 188}, {15, 375}
	};

	private final int[][] common_core = new int[][] {
		{7, 125}, {2, 38}, {2, 44}, {2, 50}, {3, 57},
		{3, 63}, {3, 69}, {5, 75}, {5, 82}, {14, 300},
		{5, 110}, {5, 124}, {6, 138}, {6, 152}, {6, 165},
		{6, 179}, {6, 193}, {6, 207}, {7, 220}, {17, 525},
		{7, 234}, {7, 248}, {7, 262}, {7, 275}, {7, 289},
		{9, 303}, {9, 317}, {9, 330}, {10, 344}, {20, 750}
	};
}
