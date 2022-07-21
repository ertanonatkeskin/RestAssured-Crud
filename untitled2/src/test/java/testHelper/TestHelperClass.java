package testHelper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;
import io.restassured.response.Response;
import net.minidev.json.parser.ParseException;
import org.apache.commons.logging.impl.WeakHashtable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class TestHelperClass {

    public static String GenareteCreateId() {
        Random rand = new Random();
        long x = (long) (rand.nextDouble() * 1000000000L);
        String createId = String.format("%010d", x);
        return createId;
    }
}