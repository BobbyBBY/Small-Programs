#include <iostream>
using namespace std;

typedef struct Link {
	int data;
	Link *next;
};

class Xiao {
public:
	Link * head;
	int *Combination;
	Xiao() {
		head = NULL;
		Combination =new int[100];
		for (int i = 0; i < 100; i++) {
			Combination[i] = 0;
		}
		Combination[0] = 1;
	}
	void iniComb() {
		Combination = new int[100];
		for (int i = 0; i < 100; i++) {
			Combination[i] = 0;
		}
		Combination[0] = 1;
	}
	void deleteLin(Link *p) {
		if (p == NULL) {
			return;
		}
		else {
			Link *q;
			while (p == NULL) {
				q = p;
				p = p->next;
				delete q;
			}
		}
	}
	void two(int a,int b) {
		int ini10 = transform10(a, b);
		head = new Link;
		Link *Head = head;//这句话是后写的，补了之前的坑
		head->data = a;
		head->next = new Link;
		head = head->next;
		head->data = b;
		head->next = NULL;
		write(transform10(a, b));
		do {
			b = (a + b) % 10;
			a = (b - a + 10) % 10;
			head->next = new Link;
			head = head->next;
			head->data = b;
			head->next = NULL;
			write(transform10(a, b));
		}while (ini10 != transform10(a, b));
		head = Head;
	}
	void one(int a) {
		two(a, a);
	}
	void displayLink() {
		cout << endl;
		Link *p = head;
		while (p != NULL) {
			for (int i = 0; (i < 10) && (p != NULL); i++) {
				cout << p->data;
				p = p->next;
			}
			cout << endl;
		}
		cout << endl;
	}
	void displayComb() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cout << Combination[transform10(i, j)];
			}
			cout << endl;
		}
		cout << endl;
	}
	void displayCombNum(int k) {
		cout << endl;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (Combination[transform10(i, j)] == k)
					cout << transform10(i, j) << " ";
			}
			cout << endl;
		}
		cout << endl;
	}

private:
	bool judge(int a,int b) {
		if (Combination[transform10(a, b)] == 0) 
			return false;
		else return true;
	}
	void write(int loca10) {
		if (Combination[loca10] == 0) {
			Combination[loca10] = 1;
		}
	}
	int transform10(int a, int b) {
		return (a * 10 + b);
	}

};

int main() {
	Xiao qwer =Xiao();
	qwer.two(2, 6);
	qwer.two(1, 3);
	qwer.one(1);
	qwer.one(2);
	qwer.one(5);
	//qwer.displayLink();
	qwer.displayComb();
	qwer.displayCombNum(0);
	system("pause");
	return 0;
}