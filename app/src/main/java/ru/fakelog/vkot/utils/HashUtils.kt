package ru.fakelog.vkot.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.util.Log
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.security.DigestInputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

object HashUtils {
    private val TAG: String = "HashUtils"

    fun getSelfChecksum(context: Context, algorithm: String): String? {
        try {
            val packageInfo: PackageInfo = context.packageManager.getPackageInfo(
                context.packageName,
                PackageManager.GET_SIGNATURES
            )

            val apkPath = packageInfo.applicationInfo.sourceDir
            val apkFile = File(apkPath)

            val digest = MessageDigest.getInstance(algorithm)
            val fis = FileInputStream(apkFile)
            val dis = DigestInputStream(fis, digest)

            val buffer = ByteArray(8192)
            while (dis.read(buffer) != -1) {
                // Чтение файла для обновления хэш-суммы
            }

            dis.close()

            val hash = digest.digest()
            val hexString = StringBuilder()

            for (b in hash) {
                val hex = Integer.toHexString(0xFF and b.toInt())
                if (hex.length == 1) {
                    hexString.append('0')
                }
                hexString.append(hex)
            }

            return hexString.toString()

        } catch (e: PackageManager.NameNotFoundException) {
            Log.e(TAG, "Ошибка при вычислении хэш-суммы: ${e.message}")
        } catch (e: NoSuchAlgorithmException) {
            Log.e(TAG, "Ошибка при вычислении хэш-суммы: ${e.message}")
        } catch (e: IOException) {
            Log.e(TAG, "Ошибка при вычислении хэш-суммы: ${e.message}")
        }

        return null
    }
}