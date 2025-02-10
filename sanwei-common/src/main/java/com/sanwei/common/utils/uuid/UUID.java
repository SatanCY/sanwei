package com.sanwei.common.utils.uuid;


import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * @author sanwei
 * @date 2025-02-08 13:17:57
 */
public final class UUID implements Serializable, Comparable<UUID> {

    private static final long serialVersionUID = -1085015143654744613L;

    private static class Holder {
        static final SecureRandom numberGenerator = getSecureRandom();
    }

    private final long mostSigBits;
    private final long leastSigBits;

    private static SecureRandom getSecureRandom() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private UUID(byte[] data) {
        //数据长度必须为16个字节
        long msb = 0;
        long lsb = 0;
        assert data.length == 16 : "数据长度必须为16个字节";
        for (int i = 0; i<8; i++) {
            msb = (msb << 8) | (data[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (data[i] & 0xff);
        }

        this.mostSigBits = msb;
        this.leastSigBits = lsb;
    }

    private UUID(long mostSigBits, long leastSigBits) {
        this.mostSigBits = mostSigBits;
        this.leastSigBits = leastSigBits;
    }

    private static UUID fastUUID() {
        return randomUUID(false);
    }

    private static UUID randomUUID() {
        return randomUUID(true);
    }

    public static UUID randomUUID(boolean isSecure) {
        final Random rd = isSecure ? Holder.numberGenerator : getSecureRandom();
        byte[] randomBytes = new byte[16];
        rd.nextBytes(randomBytes);
        randomBytes[6] &= 0x0f;
        randomBytes[6] |= 0x40;
        randomBytes[8] &= 0x3f;
        randomBytes[8] |= 0x80;
        System.out.println("UUID v4" + new String(randomBytes, StandardCharsets.UTF_8));
        return new UUID(randomBytes);
    }

    public String toString(boolean isSimple) {
        final StringBuilder builder = new StringBuilder(isSimple ? 32 : 36);


        return builder.toString();
    }

    public long getMostSigBits() {
        return mostSigBits;
    }

    public long getLeastSigBits() {
        return leastSigBits;
    }

    @Override
    public int compareTo(UUID o) {
        return 0;
    }
}
