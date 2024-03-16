#include <stdio.h>
main() {
	int x, y, z, temp;
	while (1) {
		scanf("%d %d %d", &x, &y, &z);
		if (x == 0 && y == 0 && z == 0)
			exit(0);
		if (z < x || z < y) {
			temp = z;
			if (x > y) {
				z = x;
				x = temp;
			}
			else {
				z = y;
				y = temp;
			}
		}
		if (x * x + y * y == z * z)
			printf("right\n");
		else
			printf("wrong\n");
	}
}