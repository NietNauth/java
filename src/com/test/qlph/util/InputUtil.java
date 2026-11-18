package com.test.qlph.util;

import com.test.qlph.constant.KaraokeConstant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public final class InputUtil {
    private static final String PHONE_REGEX = "^0\\d{9}$";
    private static final String EMAIL_REGEX = "^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);

    private InputUtil() {
    }

    private static String read(String prompt) {
        System.out.print(prompt);
        return KaraokeConstant.sc.nextLine().trim();
    }

    private static String keepHint(Object oldValue) {
        return " (Enter de giu: " + oldValue + "): ";
    }

    public static int inputInt(String prompt) {
        while (true) {
            String value = read(prompt);
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
            }
        }
    }

    public static String inputString(String prompt) {
        while (true) {
            String value = read(prompt + ": ");
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Khong duoc de trong");
        }
    }

    public static String inputString(String prompt, String oldValue) {
        String value = read(prompt + keepHint(oldValue));
        return value.isEmpty() ? oldValue : value;
    }

    private static Long parsePositiveLong(String value) {
        try {
            long number = Long.parseLong(value);
            if (number > 0) {
                return number;
            }
            System.out.println("Gia tri phai lon hon 0");
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so hop le");
        }
        return null;
    }

    public static Long inputPositiveLong(String prompt) {
        while (true) {
            Long number = parsePositiveLong(read(prompt + ": "));
            if (number != null) {
                return number;
            }
        }
    }

    public static Long inputPositiveLong(String prompt, Long oldValue) {
        while (true) {
            String value = read(prompt + keepHint(oldValue));
            if (value.isEmpty()) {
                return oldValue;
            }
            Long number = parsePositiveLong(value);
            if (number != null) {
                return number;
            }
        }
    }

    private static String inputPattern(String prompt, String oldValue, String regex, String error) {
        while (true) {
            String value = read(oldValue == null ? prompt + ": " : prompt + keepHint(oldValue));
            if (value.isEmpty() && oldValue != null) {
                return oldValue;
            }
            if (value.matches(regex)) {
                return value;
            }
            System.out.println(error);
        }
    }

    public static String inputPhone(String prompt) {
        return inputPhone(prompt, null);
    }

    public static String inputPhone(String prompt, String oldValue) {
        return inputPattern(prompt, oldValue, PHONE_REGEX, "SDT phai gom 10 so va bat dau bang 0");
    }

    public static String inputEmail(String prompt) {
        return inputEmail(prompt, null);
    }

    public static String inputEmail(String prompt, String oldValue) {
        return inputPattern(prompt, oldValue, EMAIL_REGEX, "Email khong hop le (VD: abc@gmail.com)");
    }

    public static String inputDate(String prompt) {
        return inputDate(prompt, null);
    }

    public static String inputDate(String prompt, String oldValue) {
        while (true) {
            String value = read(oldValue == null ? prompt + " (dd/MM/yyyy): " : prompt + keepHint(oldValue));
            if (value.isEmpty() && oldValue != null) {
                return oldValue;
            }
            try {
                LocalDate.parse(value, DATE_FORMAT);
                return value;
            } catch (DateTimeParseException e) {
                System.out.println("Ngay khong hop le, dung dinh dang dd/MM/yyyy (VD: 12/11/2026)");
            }
        }
    }

    public static String inputTime(String prompt) {
        return inputTime(prompt, null);
    }

    public static String inputTime(String prompt, String oldValue) {
        while (true) {
            String value = read(oldValue == null ? prompt + " (HH:mm): " : prompt + keepHint(oldValue));
            if (value.isEmpty() && oldValue != null) {
                return oldValue;
            }
            try {
                LocalTime.parse(value, TIME_FORMAT);
                return value;
            } catch (DateTimeParseException e) {
                System.out.println("Gio khong hop le, dung dinh dang HH:mm (VD: 19:30)");
            }
        }
    }

    public static String inputChoice(String prompt, String[] options) {
        return inputChoice(prompt, options, null);
    }

    public static String inputChoice(String prompt, String[] options, String oldValue) {
        while (true) {
            System.out.println(prompt + ":");
            for (int i = 0; i < options.length; i++) {
                System.out.println("  " + (i + 1) + ". " + options[i]);
            }
            String value = read(oldValue == null ? "Chon: " : "Chon" + keepHint(oldValue));
            if (value.isEmpty() && oldValue != null) {
                return oldValue;
            }
            try {
                int index = Integer.parseInt(value);
                if (index >= 1 && index <= options.length) {
                    return options[index - 1];
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Lua chon khong hop le");
        }
    }

    public static boolean confirm(String prompt) {
        while (true) {
            String value = read(prompt + " (y/n): ").toLowerCase();
            if (value.equals("y")) {
                return true;
            }
            if (value.equals("n")) {
                return false;
            }
            System.out.println("Vui long nhap y hoac n");
        }
    }
}
