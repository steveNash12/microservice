package xyz.songxl.security;

/**
 * @author songxl
 * @create 2019-07-09 14:11
 * @desc ${DESCRIPTION}
 **/
public class CurrentUserHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String get() {
        return holder.get() == null ? "unknow":holder.get();
    }

    public static void set(String user) {
        holder.set(user);
    }
}
