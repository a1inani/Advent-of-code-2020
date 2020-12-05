/* Author: Alinani */
/* 5/12/2020 */

/*
--- Day 5: Binary Boarding ---
You board your plane only to discover a new problem: you dropped your boarding pass! You aren't sure which seat is yours, and all of the flight attendants are busy with the flood of people that suddenly made it through passport control.

You write a quick program to use your phone's camera to scan all of the nearby boarding passes (your puzzle input); perhaps you can find your seat through process of elimination.

Instead of zones or groups, this airline uses binary space partitioning to seat people. A seat might be specified like FBFBBFFRLR, where F means "front", B means "back", L means "left", and R means "right".

The first 7 characters will either be F or B; these specify exactly one of the 128 rows on the plane (numbered 0 through 127). Each letter tells you which half of a region the given seat is in. Start with the whole list of rows; the first letter indicates whether the seat is in the front (0 through 63) or the back (64 through 127). The next letter indicates which half of that region the seat is in, and so on until you're left with exactly one row.

For example, consider just the first seven characters of FBFBBFFRLR:

Start by considering the whole range, rows 0 through 127.
F means to take the lower half, keeping rows 0 through 63.
B means to take the upper half, keeping rows 32 through 63.
F means to take the lower half, keeping rows 32 through 47.
B means to take the upper half, keeping rows 40 through 47.
B keeps rows 44 through 47.
F keeps rows 44 through 45.
The final F keeps the lower of the two, row 44.
The last three characters will be either L or R; these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7). The same process as above proceeds again, this time with only three steps. L means to keep the lower half, while R means to keep the upper half.

For example, consider just the last 3 characters of FBFBBFFRLR:

Start by considering the whole range, columns 0 through 7.
R means to take the upper half, keeping columns 4 through 7.
L means to take the lower half, keeping columns 4 through 5.
The final R keeps the upper of the two, column 5.
So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5.

Every seat also has a unique seat ID: multiply the row by 8, then add the column. In this example, the seat has ID 44 * 8 + 5 = 357.

Here are some other boarding passes:

BFFFBBFRRR: row 70, column 7, seat ID 567.
FFFBBBFRRR: row 14, column 7, seat ID 119.
BBFFBBFRLL: row 102, column 4, seat ID 820.
As a sanity check, look through your list of boarding passes. What is the highest seat ID on a boarding pass?
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Part1 {
    public static void main(String[] args) throws Exception {
        //read input from txt file
        File file = new File("/Users/Alinani/Desktop/Advent-of-code-2020/Day5/src/input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int highest = 0, column = 0, row = 0;
        while((st = br.readLine()) != null) {
            if(st.charAt(0) == 'F') {
                if(st.charAt(1) == 'F') {
                    if(st.charAt(2) == 'F') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 0;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 1;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 2;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 3;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 4;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 5;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 6;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 7;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 8;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 9;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 10;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 11;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 12;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 13;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 14;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 15;
                                    }
                                }
                            }
                        }
                    } else if(st.charAt(2) == 'B') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 16;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 17;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 18;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 19;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 20;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 21;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 22;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 23;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 24;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 25;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 26;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 27;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 28;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 29;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 30;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 31;
                                    }
                                }
                            }
                        }
                    }
                } else if(st.charAt(1) == 'B') {
                    if(st.charAt(2) == 'F') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 32;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 33;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 34;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 35;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 36;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 37;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 38;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 39;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 40;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 41;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 42;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 43;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 44;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 45;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 46;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 47;
                                    }
                                }
                            }
                        }
                    } else if(st.charAt(2) == 'B') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 48;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 49;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 50;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 51;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 52;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 53;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 54;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 55;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 56;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 57;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 58;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 59;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 60;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 61;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 62;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 63;
                                    }
                                }
                            }
                        }
                    }
                }
            } else if(st.charAt(0) == 'B') {
                if(st.charAt(1) == 'F') {
                    if(st.charAt(2) == 'F') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 64;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 65;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 66;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 67;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 68;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 69;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 70;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 71;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 72;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 73;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 74;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 75;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 76;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 77;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 78;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 79;
                                    }
                                }
                            }
                        }
                    } else if(st.charAt(2) == 'B') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 80;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 81;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 82;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 83;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 84;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 85;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 86;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 87;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 88;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 89;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 90;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 91;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 92;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 93;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 94;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 95;
                                    }
                                }
                            }
                        }
                    }
                } else if(st.charAt(1) == 'B') {
                    if(st.charAt(2) == 'F') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 96;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 97;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 98;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 99;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 100;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 101;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 102;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 103;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 104;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 105;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 106;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 107;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 108;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 109;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 110;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 111;
                                    }
                                }
                            }
                        }
                    } else if(st.charAt(2) == 'B') {
                        if(st.charAt(3) == 'F') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 112;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 113;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 114;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 115;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 116;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 117;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 118;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 119;
                                    }
                                }
                            }
                        } else if(st.charAt(3) == 'B') {
                            if(st.charAt(4) == 'F') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 120;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 121;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 122;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 123;
                                    }
                                }
                            } else if(st.charAt(4) == 'B') {
                                if(st.charAt(5) == 'F') {
                                    if(st.charAt(6) == 'F') {
                                        row = 124;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 125;
                                    }
                                } else if(st.charAt(5) == 'B') {
                                    if(st.charAt(6) == 'F') {
                                        row = 126;
                                    } else if(st.charAt(6) == 'B') {
                                        row = 127;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(st.charAt(7) == 'L') {
                if(st.charAt(8) == 'L') {
                    if(st.charAt(9) == 'L') {
                        column = 0;
                    } else if(st.charAt(9) == 'R') {
                        column = 1;
                    }
                } else if(st.charAt(8) == 'R') {
                    if(st.charAt(9) == 'L') {
                        column = 2;
                    } else if(st.charAt(9) == 'R') {
                        column = 3;
                    }
                }
            } else if(st.charAt(7) == 'R') {
                if(st.charAt(8) == 'L') {
                    if(st.charAt(9) == 'L') {
                        column = 4;
                    } else if(st.charAt(9) == 'R') {
                        column = 5;
                    }
                } else if(st.charAt(8) == 'R') {
                    if(st.charAt(9) == 'L') {
                        column = 6;
                    } else if(st.charAt(9) == 'R') {
                        column = 7;
                    }
                }
            }
            int product = row * 8;
            int sum = product + column;
            if(sum > highest) {
                highest = sum;
            }
        }
        System.out.println(highest);
    }
}
