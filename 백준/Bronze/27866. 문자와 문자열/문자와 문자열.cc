#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char* argv[]) {
    string word; cin >> word;
    int position; cin >> position;
    cout << word[position-1] << endl;
}