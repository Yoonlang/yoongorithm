## Finished in NEVER

It was a hard problem.

Because the numbers were pretty large, and it looked like counting every single
possiblity is going to take a long time.

So, I thought of greedy way. Modulo-ing by 6.

However, that was not enough. It needed some actual math to solve it.

I wasted a lot of time with wrong ideas.

However, I created a auto test script, and I hope it will be useful for
future problems.

```ts
// FIXME: constants
const FIND_N_CASES = 10;
const MY_CPP_CODE = "./my.cpp";
const ANSWER_CPP_CODE = "./main.cpp";
const OUT_FILE_NAME = "output.txt";
const INPUT_PROPS = {
  N: 10,
};

// FIXME: input generator
function makeInput(props: InputGeneratorProps): string {
  const { N } = props;
  let args: number[];
  args = Array(N).fill(0);

  for (let i = 0; i < N; i++) {
    args[i] = Math.floor(Math.random() * N);
  }

  return [N, ...args].join(" ");
}

/************************************/
//   Below are not to be modified   //
/************************************/

// @ts-ignore - no type definition
import { spawnSync, execSync, SpawnSyncReturns } from "child_process";
// @ts-ignore - no type definition
import fs from "fs";
// @ts-ignore - no type definition
import { Buffer } from "node";

const COMPILER = "g++";
const COMPILER_OPTION = "c++11";
const FILE_EXTENSION = /\.cpp$/;

type InputGeneratorProps = typeof INPUT_PROPS;

interface FindDifferentCasesInterface {
  myCode?: CodeProcessor;
  answerCode?: CodeProcessor;
  inputGen?: InputGenerator;
  findingCases?: number;
  outFile?: string;
}

class InputGenerator {
  private props: InputGeneratorProps;
  private generator: (props: InputGeneratorProps) => string;
  input = "";

  constructor(props: InputGeneratorProps, generator = makeInput) {
    this.props = props;
    this.generator = generator;

    this.make();
  }

  make() {
    this.input = this.generator(this.props);
  }
}

class CodeProcessor {
  private code: string;
  private compiled: string;
  executable = {} as SpawnSyncReturns<Buffer>;

  constructor(code: string) {
    this.code = code;
    this.compiled = code.replace(FILE_EXTENSION, "");

    this.compile();
  }
  private compile() {
    execSync(
      `${COMPILER} -std=${COMPILER_OPTION} ${this.code} -o ${this.compiled}`
    );
  }
  execute(input: string) {
    this.executable = spawnSync(this.compiled, { input });
  }
}

class FindDifferentCases {
  private myCode: CodeProcessor;
  private answerCode: CodeProcessor;
  private inputGen: InputGenerator;
  private findingCases: number;
  private outFile: string;
  private case = 0;

  constructor({
    myCode = new CodeProcessor("my.cpp"),
    answerCode = new CodeProcessor("main.cpp"),
    inputGen = new InputGenerator(INPUT_PROPS),
    findingCases = FIND_N_CASES,
    outFile = "output.txt",
  }: FindDifferentCasesInterface) {
    this.myCode = myCode;
    this.answerCode = answerCode;
    this.inputGen = inputGen;
    this.findingCases = findingCases;
    this.outFile = outFile;
  }

  run() {
    this.makeFile();

    while (this.case < this.findingCases) {
      this.setup();
      if (this.isOutputDifferent()) {
        this.logToConsole();
        this.logToFile();
        this.case++;
      }
    }
  }

  private setup() {
    this.inputGen.make();
    this.myCode.execute(this.inputGen.input);
    this.answerCode.execute(this.inputGen.input);
  }

  private isOutputDifferent() {
    return this.myResult !== this.answerResult;
  }

  private logToConsole() {
    console.log(this.prettyPrint);
  }

  private logToFile() {
    fs.appendFileSync(this.outFile, this.prettyPrint);
  }

  private makeFile() {
    fs.writeFileSync(this.outFile, "");
  }

  private get myResult() {
    return this.myCode.executable.stdout.toString().trim();
  }
  private get answerResult() {
    return this.answerCode.executable.stdout.toString().trim();
  }
  private get prettyPrint() {
    return `${this.inputGen.input}\nexpected: ${this.answerResult}\nreceived: ${this.myResult}\n\n`;
  }
}

const main = () => {
  const compare = new FindDifferentCases({
    myCode: new CodeProcessor(MY_CPP_CODE),
    answerCode: new CodeProcessor(ANSWER_CPP_CODE),
    outFile: OUT_FILE_NAME,
    findingCases: FIND_N_CASES,
    inputGen: new InputGenerator(INPUT_PROPS),
  });
  compare.run();
};

main();
```
