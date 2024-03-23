#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredients) {
	vector<int> ingredientStack;
	int result = 0;

	for (int ingredient : ingredients) {
		ingredientStack.push_back(ingredient);

		int stackSize = ingredientStack.size();

		if (stackSize >= 4) {
			if (ingredientStack[stackSize - 1] == 1 &&
				ingredientStack[stackSize - 2] == 3 &&
				ingredientStack[stackSize - 3] == 2 &&
				ingredientStack[stackSize - 4] == 1) {

				ingredientStack.pop_back();
				ingredientStack.pop_back();
				ingredientStack.pop_back();
				ingredientStack.pop_back();
				
				result++;
			}
		}
	}
    
    return result;
}