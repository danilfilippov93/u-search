import os, sys, argparse, re

tmp_file = os.path.join("latex", "temp.tex")

def fix_class_index(input_file):
    fin = open(input_file, "r")
    fout = open(tmp_file, "w")
    chapter_re = re.compile(r"\\chapter\{")

    while True:
        line = fin.readline()
        if line == '':
            break

        if re.search(chapter_re, line) != None:
            next_line = fin.readline()
            if next_line == "\input{hierarchy}\n":
                line = "\chapter{\-Class \-Index}\n\input{hierarchy}\n"
            if next_line == "\input{annotated}\n":
                line = next_line

        fout.write(line)

    fin.close()
    fout.close()
    os.rename(tmp_file, input_file)

def main():
    parser = argparse.ArgumentParser(add_help = True, version = 0.0)

    parser.add_argument("input_file", type = str, action = "store", help = "File"
                        "to parse")

    args = parser.parse_args()

    fix_class_index(args.input_file)

    return 0

if __name__ == "__main__":
    sys.exit(main())