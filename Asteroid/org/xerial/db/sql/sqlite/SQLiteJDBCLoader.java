/*--------------------------------------------------------------------------
 *  Copyright 2007 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// SQLite JDBC Project
//
// SQLite.java
// Since: 2007/05/10
//
// $URL$ 
// $Author$
//--------------------------------------
package org.xerial.db.sql.sqlite;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Set the system properties, org.sqlite.lib.path, org.sqlite.lib.name,
 * appropriately so that the SQLite JDBC driver can find *.dll, *.jnilib and
 * *.so files, according to the current OS (win, linux, mac).
 * 
 * The library files are automatically extracted from this project's package
 * (JAR).
 * 
 * usage: call {@link #initialize()} before using SQLite JDBC driver.
 * 
 * @author leo
 * 
 */
public class SQLiteJDBCLoader
{

    private static boolean extracted = false;

    public static boolean initialize()
    {
        loadSQLiteNativeLibrary();
        return extracted;
    }

    public static boolean initialize(boolean forceReload)
    {
        if (forceReload)
            extracted = false;
        loadSQLiteNativeLibrary();
        return extracted;
    }

    private static String md5sum(InputStream input) throws IOException, NoSuchAlgorithmException
    {
        BufferedInputStream in = new BufferedInputStream(input);

        try
        {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            DigestInputStream digestInputStream = new DigestInputStream(in, digest);
            for (; digestInputStream.read() >= 0;)
            {

            }
            ByteArrayOutputStream md5out = new ByteArrayOutputStream();
            md5out.write(digest.digest());
            return md5out.toString();
        }
        finally
        {
            in.close();
        }
    }

    private static boolean extractLibraryFile(String libFolderForCurrentOS, String libraryFileName, String targetFolder)
    {
        String nativeLibraryFilePath = libFolderForCurrentOS + "/" + libraryFileName;

        File extractedLibFile = new File(targetFolder, libraryFileName);

        try
        {
            if (extractedLibFile.exists())
            {
                // test md5sum value
                String md5sum1 = md5sum(SQLiteJDBCLoader.class.getResourceAsStream(nativeLibraryFilePath));
                String md5sum2 = md5sum(new FileInputStream(extractedLibFile));

                if (md5sum1.equals(md5sum2))
                {
                    return loadNativeLibrary(targetFolder, libraryFileName);
                }
                else
                {
                    // remove old native library file
                    boolean deletionSucceeded = extractedLibFile.delete();
                    if (!deletionSucceeded)
                    {
                        throw new IOException("failed to remove existing native library file: "
                                + extractedLibFile.getAbsolutePath());
                    }
                }
            }

            // extract file into the current directory
            InputStream reader = SQLiteJDBCLoader.class.getResourceAsStream(nativeLibraryFilePath);
            FileOutputStream writer = new FileOutputStream(extractedLibFile);
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = reader.read(buffer)) != -1)
            {
                writer.write(buffer, 0, bytesRead);
            }

            writer.close();
            reader.close();

            if (!System.getProperty("os.name").contains("Windows"))
            {
                try
                {
                    Runtime.getRuntime().exec(new String[] { "chmod", "755", extractedLibFile.getAbsolutePath() })
                            .waitFor();
                }
                catch (Throwable e)
                {}
            }

            return loadNativeLibrary(targetFolder, libraryFileName);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
            return false;
        }
        catch (NoSuchAlgorithmException e)
        {
            System.err.println(e.getMessage());
            return false;
        }

    }

    private static synchronized boolean loadNativeLibrary(String path, String name)
    {
        File libPath = new File(path, name);
        if (libPath.exists())
        {
            // System.setProperty("org.sqlite.lib.path", path == null ? "./" :
            // path);
            // System.setProperty("org.sqlite.lib.name", name);

            try
            {
                System.load(new File(path, name).getAbsolutePath());
                return true;
            }
            catch (UnsatisfiedLinkError e)
            {
                System.err.println(e);
                return false;
            }

        }
        else
            return false;
    }

    private static void loadSQLiteNativeLibrary()
    {
        if (extracted)
            return;

        // Try loading library from org.sqlite.lib.path library path */
        String sqliteNativeLibraryPath = System.getProperty("org.sqlite.lib.path");
        String sqliteNativeLibraryName = System.getProperty("org.sqlite.lib.name");
        if (sqliteNativeLibraryName == null)
            sqliteNativeLibraryName = System.mapLibraryName("sqlitejdbc");

        if (sqliteNativeLibraryPath != null)
        {
            if (loadNativeLibrary(sqliteNativeLibraryPath, sqliteNativeLibraryName))
            {
                extracted = true;
                return;
            }
        }

        // Load the os-dependent library from a jar file
        String osName = System.getProperty("os.name");
        if (osName.contains("Windows"))
        {
            sqliteNativeLibraryPath = "/native/win";
        }
        else if (osName.contains("Mac"))
        {
            sqliteNativeLibraryPath = "/native/mac";
        }
        else if (osName.contains("Linux"))
        {
            sqliteNativeLibraryPath = "/native/linux";
        }
        else
            throw new UnsupportedOperationException("unsupported OS for SQLite-JDBC driver: " + osName);

        // temporary library folder
        String tempFolder = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        /* Try extracting thelibrary from jar */
        if (extractLibraryFile(sqliteNativeLibraryPath, sqliteNativeLibraryName, tempFolder))
        {
            extracted = true;
            return;
        }

        extracted = false;
        return;
    }

}
