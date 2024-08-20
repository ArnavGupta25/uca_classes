//basic approach without bit

// #include <bits/stdc++.h>
// using namespace std;

// int getCardValue(char value) {
//     if (value == 'A') return 14;
//     if (value == 'K') return 13;
//     if (value == 'Q') return 12;
//     if (value == 'J') return 11;
//     return value - '0';
// }

// void compareCards(string card1, string card2) {
//     char value1 = card1[0];
//     char suit1 = card1[1];
//     char value2 = card2[0];
//     char suit2 = card2[1];

//     int intValue1 = getCardValue(value1);
//     int intValue2 = getCardValue(value2);

//     if (intValue1 > intValue2) {
//         cout << "Card 1 (" << value1 << suit1 << ") is of higher value than Card 2 (" << value2 << suit2 << ").\n";
//     } else if (intValue1 < intValue2) {
//         cout << "Card 2 (" << value2 << suit2 << ") is of higher value than Card 1 (" << value1 << suit1 << ").\n";
//     } else {
//         cout << "Card 1 (" << value1 << suit1 << ") and Card 2 (" << value2 << suit2 << ") are of equal value.\n";
//     }

//     if (suit1 == suit2) {
//         cout << "Both cards are of the same suit (" << suit1 << ").\n";
//     } else {
//         cout << "The cards are of different suits.\n";
//     }
// }

// int main() {
//     string card1, card2;

//     cout << "Enter the first card (e.g., 9H, KS, 5D, QC): ";
//     cin >> card1;
//     cout << "Enter the second card (e.g., 9H, KS, 5D, QC): ";
//     cin >> card2;

//     compareCards(card1, card2);

//     return 0;
// }



//bit manipulation approach