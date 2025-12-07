package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/complex-number-multiplication/
 */
public class ComplexNumber {

    public String complexNumberMultiply(String num1, String num2) {

        int re1 = getReal(num1);
        int im1 = getImaginary(num1);

        int re2 = getReal(num2);
        int im2 = getImaginary(num2);

        int re = re1 * re2 - im1 * im2;
        int im = re1 * im2 + re2 * im1;

        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(re)).append("+").append(Integer.toString(im)).append("i");

        return sb.toString();
    }

    private int getReal(String num) {
        String[] parts = num.split("\\+");
        return Integer.parseInt(parts[0]);
    }

    private int getImaginary(String num) {
        String[] parts = num.split("\\+");
        return Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
    }
}
