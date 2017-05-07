package xyz.dokup.todomvvm.util;

import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * Created by e10dokup on 2017/05/07.
 */

public class TaskUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuuMMdd");

    public static long parseDeadline(String deadline) {
        LocalDate parsed = LocalDate.parse(deadline, FORMATTER);
        return parsed.atStartOfDay().toEpochSecond(ZoneId.systemDefault().getRules().getOffset(Instant.EPOCH));
    }

}
