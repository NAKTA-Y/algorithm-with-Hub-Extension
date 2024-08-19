#include <stdio.h>
#include <math.h>

int main(void)
{
	int test_case;
	int x1, y1, r1, x2, y2, r2;
	double distance;

	scanf("%d", &test_case);

	for (int i = 0; i < test_case; i++)
		{
		scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
		
			
		distance = sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));

		if (distance == 0 && r1 == r2)
		{
			printf("%d\n", -1);
		}
		else if (distance > (r1 + r2) || distance < abs(r1 - r2))
		{
			printf("%d\n", 0);
		}
		else if (distance == (r1 + r2) || distance == abs(r1 - r2))
		{
			printf("%d\n", 1);
		}
		else
		{
			printf("%d\n", 2);
		}
	}
	return 0;
}