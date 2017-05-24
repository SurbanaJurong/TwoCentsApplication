package com.mrawesome.twocents.fragment.addInterest;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.ui.adapter.InterestAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mrawesome on 21/5/17.
 */

public class AddInterestFragment1 extends Fragment {

    private static final String TAG = AddInterestFragment1.class.getSimpleName();

    public static final String footballAva = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAMAAAD04JH5AAAAA3NCSVQICAjb4U/gAAAACXBIWXMA\n" +
            "AAOSAAADkgHKEu2wAAAAGXRFWHRTb2Z0d2FyZQB3d3cuaW5rc2NhcGUub3Jnm+48GgAAAvFQTFRF\n" +
            "////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
            "AAAAAAAAAAAAAAAAnJGEggAAAPp0Uk5TAAECAwQFBgcICQoLDA0ODxAREhMUFRYXGBkaGxwdHh8g\n" +
            "ISIjJCUmJygpKissLS4vMDEyMzQ1Njc4OTo7PD0+P0BBQkNERUZHSElKS01OT1BRUlNUVVZXWFla\n" +
            "W1xdXl9gYWJkZWZnaGlqa2xtbm9wcXJzdHV2d3h5ent8fX5/gIGCg4SFhoeIiYqLjI2Oj5CRkpOU\n" +
            "lZaXmJmam5ydnp+goaKjpKWmp6ipqqusra6vsLGys7S1t7i5uru8vb6/wMHCw8TFxsfIycrLzM3O\n" +
            "z9DR0tPU1dbX2Nnb3N3e3+Dh4+Tl5ufo6err7O3u7/Dx8vP09fb3+Pn6+/z9/tnAgUUAAAlzSURB\n" +
            "VBgZvcF7QJX1Acfh7+HA8Ya3Ek0jqVxabXZlSaaroEU5u6xWmsvKbtZqlV2s2Q0d07XcrGErm5nF\n" +
            "yCjnLDPCNInVRheLyqjQSsqAdAgmt/P5a+853F7gfd/zOyjneaSeGJQ6Iyt3XdGW8sr6+sryLUXr\n" +
            "crNmpA5STAzIXLSxAkcVGxdlDlBvCqQvKG7AU0Px/PSAekdaTjUdGiq2FDy7eO6sXy/+li6qc9J0\n" +
            "wKXMK6NV8zt/PHfcUJ/a+M/5Rx1dlM1L0YGUujpIi48euWCouhl4ZeEuOguuTtWBMnk9YdXLpo+Q\n" +
            "qyEnXnjboy99VEu79ZN1IGRsJqxsdn+ZGH7KpXMff72ZkM0Z2l/J+YRtnOpTNMY+1UhIfrL2R/yc\n" +
            "PVgaVp6oqKUs3Ydlz5x49dikUiy12aPkbuLSN0fJ2ciHa7GUTlLP+LODWAqPkKuxWV8A5WPkYsQq\n" +
            "LMFsv3oguQjL7qvlJumm/9Dim/Fyc/4OLEXJitqUKixrR8lZv2nrGmn3fZrcDF6GpWqKouNbGAQq\n" +
            "p8tR3Fkrauik9udylf4FEFzoUxQCeVjykuTk+Id20E39RXLV/1kseQEZSyzAskwODrurFEdNs+Tu\n" +
            "d0GgIFGGkkqwfDdUXQ2etTGIm+BtcndxHVCSJCOjywi5XJ0lnPf8D3iaL3cn7wDKRstAUhkhr6uT\n" +
            "U3OqiOivPrk69B2gLEkRJZYQUj9ONld9jpFn4+Wq/5tASaIiCBQQliW7PAyt7StXQz4ECgLy5Msj\n" +
            "7MO+sluOqU0D5WrkF0CeT14WElZ9pDrJwdg7w+RqzDfAQnmYEiSk6Sx19ifMfZIsV8fvguAUuUqu\n" +
            "Iuw2dTGfKGw/Sq4mAVXJcuEvIuwZdXUP0fj2eLkZg6XIL2fZhL3TV13dSlR2TZSLmYRky9GkICE7\n" +
            "D1M31xOdukw5+xshwUlyEF9KSMNkdXcFUaofI0elhJXGq7s5hM2Wg0uI0vNyNLiZFnPUTfIeQp6Q\n" +
            "k6lEZ8dBcnQOrfYkq6t8QooDcnIWUQmeLWdZtMlXFxmE7DhEjk4jKo/IRSHtMtTZZiz7TpGzk4jG\n" +
            "J/3kzL+HdpvVyWRCrpSLY4hCw0lycSI2k2W3HssSuTmcKNwtNzOxWS+bVCyvx8vNCMy9GSc3yUFs\n" +
            "UtVhNbB9mFwNwljNEXK3CZvVapcShLoT5C4BY1fJw7XYBFPUZh4wTV4aMbRaXobWYzNPbcpgrTzV\n" +
            "YOabYfK0BpsytUoDLpGnnZg5V94uwS5NLXKgpp88bcfIUkXQrwabpQoLVMNKeduKibL+iuRpbKoD\n" +
            "CkkHMuXtPQw0/lQRnY1dukIWQJVf3ooxcK8i83+LzQKFFMMLiqCQyN7yy8ASbIplGdAAv1EEB2XM\n" +
            "efbjJrzU/kgmJmDTMEBSJvATmeh3ynWPvV2Hi2tk5nNsMiUtgu98MuY/5rI/vlZFN2tlKAubRZI2\n" +
            "wguKVvLU+1Zvw2bncBkah81GSRVwu3pkyBm3rvywkbCpMvYuHSqkQcBU9Vyfk6/OKa59QuZuw2aQ\n" +
            "UoGx2k9x8TI3qpkOqZoBjfGKqQ10mKEsKFNszaJDlnLhJcXW4H20y9U6eEIx9iLt1qkIFivGLqJd\n" +
            "kbZAlmKsz27abFE53KlYW06bclXCDUnnBRRTGbSpVD3MPIFdy8+OV+zEVdCqXvUwMw3Ld0t/FqdY\n" +
            "SX3wjX2E1KsabjiDFl8vnqCY6XvGAx9Apb6Eu86hXfkfjlfM3Azl+hjmX4Dd1vvHKTayYIvehr9M\n" +
            "o4v3MxULOVCkQvj7lXRVolhYBeu0El67nm6OUwxsgFzdD9tvoZtHFAMfQJZ+Dc0P0E11H/W6uFqY\n" +
            "oVOBfLqbrl53FJCq4cCndFeoXncRMEjaDU10FzxCvS0LKiQV4Gy+etsa2CjpPpx95Vcv2w6LJGXg\n" +
            "Yop615FApqTEJpy9qN51AzQMkOVdnDUMV/T6ydhaKFbIIlzcrqgdU1239ZW/zZ1+6iifIgjUwgKF\n" +
            "TMDFVkVr5Hba1H9W+OS9l/9stF8uMoB0hfi+xsVpis7A9+mmcdumpx+clT4moC6WQHVAYY/iYrmi\n" +
            "kvAa7pq/vkt2fapgqVqciYvagYqC7xk83SS7aUCaWvjrcHGNorAQb5NltwHK1GYRLt6WuRuJYLBs\n" +
            "xgRhntoMq8XFT2Tqwma8bZPdHyCYonaLcfFnGTrtByJYI5uhu2G1Oozah7OqgIwcXU0kD8pmAZAq\n" +
            "m8dwcYlMjNxGRBeqw8E1sF52hzfirEAGBr5PZEeqw0JgsjpZgbPmFEWUUEBkNT61G14Lm9XZuGac\n" +
            "PaCIVmLgTXVYAWSoi1U4+zJOEWRjIkft0oF8dTX6fzjLlLcbMHKt2vT9DPYkq5tZOJsjTxc0Y+QU\n" +
            "tfk9MEcOXsZB8E55mrgXI8391Wp8A5TGy8HIarrZe7E8javCzKdqlbgVgpPkaBpd7ZwgT4dsw9Aq\n" +
            "tVoFZMvF83T2yeHylPgepu5Ri98CRX65OPhb7DYMkaeEVzH2C4VNbICqZLmaGqTD8gR5exJzhyrk\n" +
            "8B0QnCIPt9AmeI8i+WUTpqoUMuIzYKE8LaDFD5cqshnNGNogy5APgDyfvD1OSOVEmbg6iJnFkvoX\n" +
            "AwUBRRCXDzSdIDM3YeYKacBrQEmiIgoUAu+NlJm7MPHfFI0oAcqSZCCxBPjyxzKTRST1uWnS2HKg\n" +
            "bLSMDCsFdp0pM3/CU8X9h0iaWAWUJMnQwDVA/XUysxR3/56eIMusvUBBooz5soJA/mCZ8D2Fs30r\n" +
            "TlbIoDwseQFF46JaYFuaTMQ9h4Ov7klS2IRyILjQp+iMLwca5/plIH4NXb1xcbzC4u9uAKqmKGoH\n" +
            "b8BSeoYM9FmP3d5lx6nV6R9hKUpWD8Q/1IRl1WGKrN8m2m274yC1GpmLJZjtV8+M34Sl7t6Biijx\n" +
            "LVoUnh+nVv1vr8FSOkk9N+0rLLsWJCmSIe8BtY8dqzYH3VeFZc+ceO2PAdn1WPY+MloRDPvo81sH\n" +
            "q82hD+8hJD9Z++tHLxPSsPbSfvKU6FOrPhevaSBkc4YOhHMLg4TUrMz0KyLf6U/uJmz9ZB0oRz1U\n" +
            "Sdj3/7x5vE/ujp69aidhwdWpOpD6XLaZVpUv3Hn+uAR1ETjm/Due+4ZWZfNSdMAdu2QX7Ro//dfj\n" +
            "Dz94x+zLZ9449/ePrnjliybaVeekqXckpN2+phJPDcXz0wPqVUdfveJzHFVsXJQ5QDFxyJm/mn3v\n" +
            "ktxX3/2yrr6yfEvRutysGamD1BP/B/LjwLOQmpxVAAAAAElFTkSuQmCC\n";
    public static final String basketballAva = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACAEAYAAACTrr2IAAAABmJLR0QAAAAAAAD5Q7t/AAAACXBI\n" +
            "WXMAAABIAAAASABGyWs+AAAACXZwQWcAAACAAAAAgAAw4TGaAABfeklEQVR42u29d5gdxZkv/PbJ\n" +
            "aXIejaTRKM0oCwUkkJCQQCKDWaIxwXEBw73+vGuz9tr+ww/P2tdr+66vbbBZFozJJgmwQEgEgRJC\n" +
            "WSNplGakSdJoNHnOmZNPf3+8el3d1VXdfWaGZFPPI53p6urq6qr6vbmqFPgifabT4cOXXOJ0OhwA\n" +
            "TqfDEQphblERgKIAlJbidWUl/o4ZAwCgKCUlrByAquKvovj9mO/x6H8BHA5FAUgkjh6Nx73eROK/\n" +
            "/qu7u6LC6Tx9OpVyu6n+8eMDAYcjk3nzzQceKCo6deqllxYu9PvD4dOnh4YyGYejs1NRAAC6u3Ny\n" +
            "HI5UKhyurHzzTVXNZD7tfvwiiZPyaTfgHz0dPrx6tdsdCCCgKyowt7YWAEBRZszA6ylT8P7EiXiN\n" +
            "QAfIy8PfUAhAURSFAO1w4K9iGF9FUUzHPBrNZBwOgL/+dWAgPx9gzRr8jUQw3+UCAFDV2bN9vkgk\n" +
            "Frv99vz87u5wuKbG44nF+vtVFUBR2tvD4UzG4WhsPHw4Hvf5jhz585/7+kpK2tpaWpJJjyeTwVbs\n" +
            "3OnxKIqqnjy5Z8+BA4cOpVKf9nj8o6UvCMDHnA4fXrXK5XK5kMcSwGfNAgBQlCVLEKQLFmD+lCn4\n" +
            "W1qKUPV6GVz5v3ggi0pmn+hZ4tmbNoXDoRDA00/39BQWAnR2plIuF4Cq4v3qarc7kQC45JKcnIEB\n" +
            "gIGBdNrhAGhqSiS8XoC2tmTS4wHo7k6nXa5MJp1WVUWhp1tb8XfzZqcTQFXXrfP7HY5MZtu2vDxF\n" +
            "SaVaW9ev37//+PFk8tMex7/X9AUBGKV0+PDq1S6X04nAraoCAFCUCy/Eu5ddhtBatAivx47Fcj4f\n" +
            "48g8bzZea/+Sc3IrHq+vjUrTdTqN4ESRHqCrK5l0OgHWru3vz80FePvt/v6cHEYgCMo84UBJAP+p\n" +
            "KoCqUklMLhc+EQw6HJkMQGmpy5VMplLTp/t80Whb26pVwWBf35YtVVUuVyLxxhtY75YtWFNbW23t\n" +
            "W2+lUun0pznmfw/pCwIwzISie16eFtiKcv31eL1iBUJr/Hic5m63EWr8NQ9scwIgyudLKQpTBugO\n" +
            "ATwSQU595kwy6XIBnDgRi7ndAMePx2IeD157PAAdHXifVIBUSlUJ1PJWsJSb63RmMgDjxnk8iQT7\n" +
            "ranxeuNxgHHjUIJAAgAQCChKOg3gdGpJRjKJwG9uxje/+y4AgKq+/DJef/hhbe1bbyWT/f2f9rz4\n" +
            "vKUvCIBFQhEeocQ4+zXX4JS/+WYE2nnnET8zA7oVwM0JAl8OExrvWC6K2AhYRQE4cyaRcLkAmpoQ\n" +
            "0EePRqMeD1673ex+OIwEIZXioa1PTie+x+93OFQVwOdDDt7Xl0qhGI/l6HfyZJ8vkQC4556ysu5u\n" +
            "vI7HWQlVRaAT3LW/fA7VjOUBACIRvN69G3Oefx5LvPYa9kRbW23thg1W3/SPnL4gAFzSA37yZAAA\n" +
            "RfnylxGON92EUJsyBQFHIj+WMge6Efh2OL7Doa+PpjIZ6zo7UURvbERgHz48NOTx4LXbDdDRMTyA\n" +
            "B4PIuUtLPZ50GmDCBJ8vmQSYNMnvTybZdU6O05lOA6xZ09WVkwPwzju9vYEAUwUoTZmChOAb3ygv\n" +
            "7+0FqK31++NxAPIQMFDLAK+/5n/x/3Qa/zp6VE8QnnkGIJNR1ePHa2vXr/+CILD0BQE4lw4fvuwy\n" +
            "t7umBgBAUW6/HQGIv4pSU6OcSwzIyHspVwZ0dp+SvhyrVV9LMqmqDgdAb28q5XAANDcjx25oQIAf\n" +
            "OYK/ra2Y39+P5ZJJ/eSmd1MuSQyBgNOpqlqA+/2pFMDUqYFAIgEwaVIgkEwCVFTg/VAICYLLxUx4\n" +
            "VLOqMgLz9NMdHTk5AG+80d0dDDKCQ89UVXk8qRTAN79ZUdHXB3DeecFgNCoCOLuyIgyYk8lo76uq\n" +
            "VrZoasL8J5/Ee08+WVu7bl0y2dT0ac+7Tzv9wxIABDz5x2+7DaFyzz0IwalTGeCZkI3/izm+Fedn\n" +
            "tem18mgUgU6cmjj4/v3hsJaTd3UlEk4nQDyOoj1vfOOvPR4U0YuLPZ5MBqCmJhBIpQCmTQuFkkmA\n" +
            "yZODwWQSoLLS602nAXJzXS4RwPWw0v+lTYqCcIvFsH3PP9/REQoBrFnT2RkIIGHStru42O1OpwG+\n" +
            "+tXy8v5+gKVL8/KiUVaPFvj0XruSgP45/AI9QThyBO8//DCWfPppJAjd3Z/2vPyk0z8MAUCjnceD\n" +
            "UFy9GqHyr/+K1xdcgAAldx2AHNDmnJ8HOlnDBwczGacTObbLBXDwYCTi9QLU10ciHg/AyZMIdOLk\n" +
            "xDl5+YGmN4nqOTkul6oCVFX5fKkUQG1tTo4W6AT8oiIkBEQYKDGrvZVYLLsvfjKRwJpffrmjIxgE\n" +
            "eOGFjo5AwEjAyEj4la+Ulw8OAqxeXVgYiaByxdsGspUExARDSxBSKfxr61as75e/xOu33kKjYiLx\n" +
            "ac7ZTyL93ROAw4cvu8zjqalBGH73uwipr3wFgYVWfHNgi/MVBQFOOjrlYwAMwMmTKJrv2RMO+3wA\n" +
            "e/cODqJfPB5Hq3o6rShsuhLZ4ae32435hYUI4MmTQ6FUCmD27NzcZJIBvqLC50NRHQkCLxmMXOvl\n" +
            "BX/2l+gOgTyVQkLwyitIAJ599tQpLSGgREbF226rqBgcBLjqquJiESEQAVmfb00Q5ISivx//euop\n" +
            "fOuvf11bu25dIvH3qyr83REA5PTkdrv2WpyKP/kJAnjmTCOH5+3oYsATR6f8oSEU3Vtb43Et0Pfs\n" +
            "QaATAQiHEegMGGKgezxYf2kpiuRTpyLQ58zJz0+lAOrqcnKSSYCyMq83kwHwep1O7fMEeiPQRxIW\n" +
            "pH2DMV98R6zLM0Jw+rTfD/Dss+3tfr+REPh8SAhuuaWiIhwGuPbakpKhIXSkZjIMtubGQAD7wNdf\n" +
            "6yWE+nr8np/+FHNefRUlg7+fwKS/GwKAnL68XC/af/ObCNjcXCvg0zUvwqfTyOvJX757NwJ9+/b+\n" +
            "fp8P4PhxFN0HB9EIRtOIF91pmrndWG9ZGQJ95szc3FQKYO7c/PxkEmDqVOToxcVer6qy8jzQRZGA\n" +
            "5lDPlhBYqwQizq+15uvfjuWTSVINTp3y+QCee66tTUQIvF4kBDfdVF4eiQBcf315ORECLaCNAOYJ\n" +
            "Aq/kiJ8zJwQDA/jXf/83qQooGXR0jHzmfrrpc08AEPjz5uEE/z//BwF88cUIeIfDyNH1wHc46D7+\n" +
            "Dg2hrk4BMVu3Dgz4/QC7dw8O+nzoN3c6mY5OtVGiaUQ6OonudXUI7IULCwuTSQb8khKfD41vepuB\n" +
            "EejiUODso/2tCEF2wBcZB3kdXZSfSmFP/eUvbW0+H8Dzz7e2+v1GLwbZLG69tbJyaIgRAgoU4m0D\n" +
            "Mk4/POBr68lksKyqqup77+F3PPAAEoJdu0Yyhz/N9LkjACjiO50IveuvBwBQlP/4DwT7pEl6Yd3I\n" +
            "6QnwBN2uLoxt37kzHPb7GeCPHkVrPOnqzC+P7WCiKKacHLdbVdG6nkoBLFiAQJ8zJy8vlQIYMyYQ\n" +
            "SKf1ojsCPfuIQLNIQBkBGD3+L+b8Zvf5UGD8dryOxzGc96mnmpt9PoBXXmlv93pZxCIlUg3uuGPs\n" +
            "2KEhgKuvLi0dGtKGGtvj9NbAtyYIFLmgqseP49t/+EOfDyCdfvnl8ePffDOd/vyEKH9uCAByep8P\n" +
            "h/zee3Gi/+hHyNkLChin1wOcAE9A6+hIJt1ugC1bBgcDAYD33+/vDwSYP50mnpX1vbISjW7E0Rcv\n" +
            "LirCENdgMJ0GCAZx3RzVlMnI4gSMnH64IcL6nJHq/nySOQLFBIAHvNE2oDcWDg3hSsD/+Z+mJp8P\n" +
            "4I03Tp1ii5XZ0xS/8PWvjxsXiQCsXl1aGosBOBxiFUAGZAI6g7P+fibD7mt/WTntb28vqjAPPtjb\n" +
            "q6ou10MPrV69YcPgYCw2umMw+ukzTwAQ+BRz/+//jgC47z4Eut+vFfFR4EcOm8ngdWtrIuHxAHzw\n" +
            "wcBAIACwZQv+nj6NfnfiG8TZ+WkaDKJVfcoUNMotWYJAnzevoCCZBCgt9flUFVfr43u1DkH2qzUq\n" +
            "nut6m5GD5jq/2RrA0SEE5sC38gYYS4rdc2g/ARgcRAPbww8fO+bzAbz3XkcH6f3aWsj9+a1vVVdH\n" +
            "IgCzZqFXZHAwmUS3K9YzMIDX4TD+kkQXiaRS2l+KXyD3ZTKJ12SzYAFN4rgIZBzRaDoNoCgPPeTz\n" +
            "KUom8x//8cwzu3adONHTM7Ix+PjSZ5YAIPBp44uf/QwB9NWvIuDRX4+A13P81lZcfrp+fV9fKASw\n" +
            "bRty+rNnMWSWRcThLxEAgklpKers8+bl5ycSAEuWFBcnEmicQzeb2w3AJAqmq7M1+HbiBKwWB8kl\n" +
            "g78NnS1JwMoiYJWMnFx8JRP9eU7PWoP302kcgVgMIRaJIHAPHerrczoB/vjHY8e8XoCurnhcS/Do\n" +
            "XcEgSgREEGIxrC8aRaCnUghkEspJwmMqGP8dYssLa795r2MgVTqNS6Zfey2RUFWH49///cCBgwcP\n" +
            "HmxoGMlYfBzpM0cAEPi4Hh7gV79CTo+x+Pg3AR+F8Z4e7Ox33x0YCIUY8E+fRqs9P5C8351E+Ysu\n" +
            "KiqKxwEuuggBP3ZsIKA1zmlFeIoAoJrtxg9oyxs5v7kqYCQIcsnA+Jf4vjiZaf/y+zzASZSOx1G0\n" +
            "7+/HJUCnT0ciAAAnTgwOKgrAyZP4e+pUJKIoAJ2dsZiiAPT3JxIYKYlAZqqZuLUEZBpXnw8Jg9eL\n" +
            "4xQIYMBRKIT5oRBGPlIgEsUh4I5H7Bc5OQIbf/FNxEycTmIi+H86rSdswaCipNPvvltT43bHYrff\n" +
            "vmTJhg1DQ6dODQcbH0f6zBAABH5xMQ7xb36DYL/1VuLxxOnJLbdnz9CQ3w/w4os9PXl5AIcPR6Ne\n" +
            "r1Gk563y48djZNzy5Qh4EunLy/3+TIYF9qgqHx8wvIAhu5xfTij+NlQGgiArZxjkUYwEYIHMmBIJ\n" +
            "hGZ3dzQKANDcPDAAANDQ0NOjKADHjvX1AQC0tSHAe3oQ4LEY8mTGkXm3Ibaa9g3w+dCmQuNJz/MS\n" +
            "QV4eGmO/9rUJE6JRgNpaVN1o1SIB2uPRA5hsCIqiNfJp38hsBAR4vdGQXWvvo+0Ac1X12Wfxrf/7\n" +
            "f6P3oKtrZCMz8vSpEwAEfkGBnuPfeScC3+FwOhFY3d2ZjMsFsGZNb29eHm5MEQqxyDse8MS5aVHL\n" +
            "ihXFxfE4wKJFBQWJBHO/EXBVFQmLzF1oN2CIAVRGQOwSBGsVQJwvz82GEDgcaKcnYEUiGBbb2jo4\n" +
            "CABw4MDZswAA9fU4iU+cwLX4XV1ICAigMnmC2kJekYICjHuorAwGAQBqanJyMhmA6upQKJMBqKoK\n" +
            "BlWVSQyPPnrkCEZUog7Pf9uKFWVlySTAt789adLQEHJ0kTGP/AciIIu9BghwvrwdAoHvzmRU9Ykn\n" +
            "sGf+5V+QEPT2Dg89I0+fGgFA4NNeeD//OQLm3nuR1zudBKAjR+Jxnw/gySe7uwsKAOrrh4Z8PsGH\n" +
            "nPsSin2//PKSkmgUYPHigoJ4nE0wEuF5Ds97D+wTAqt8o6RALdbfZ18ikxD032pfFRDl0N8sBBmv\n" +
            "w+FEQlUBmpqQc+/a1dGhqgD79nV2qipAczMCvb8fCQJNb5loThGOhYU4atXVuI9hXV1BARpX8/NV\n" +
            "lQG8sNDjUVUmwlMAEQExmUSZ4Zlnjh93uQCeeaaxEY25elJD33XrrePHx+MAt9wyblw8jpxeD2Bz\n" +
            "NyDP0UXAx/qM9cgJQTqN1w89hD31b/+GhGBoaNQAZjN94gQAV+FRqO73v48A+MlPFMXpVBSPJ5lU\n" +
            "FKcT4P33cS+655/v7s7PZ3vRaXVMAICKCoyou+wyBPzFFxcVxWKMwxNnN3JuihewFyEoWiSUTf5o\n" +
            "qwJGDi8z9+ltCNSqWAx18xMn+vpUFWDnztOnMxn8VVWAxsbeXrTKI9B54ynP2f1+FNGrqnJyFAVg\n" +
            "xgzcmXjmzOJiAICJE/PzAQBKSvx+BDhyZIoHQEFZ747Tj7Q2CBhgaAgJ1W9/e+CAywXwzjvt7drd\n" +
            "GXgj4f33T50aiwEsX15amkwySUAOWBlhkEkAcklCXy9ZBzIZVU0k8D0UavyLX+CqxE8u1Nj1Sb2I\n" +
            "JUWhxTiK8sADyO09np6eTMbtBnjxxd7e/HyAt98eGMjJAYjFcBkpDanfjwO6ZEl+fiwGcO21ZWVD\n" +
            "QwDV1cj5FQUdcuQG1AJYJOKLAK5/TibyW0kKPIBlhGK4xkH9XfqLfxsBobsbucvevWfOZDIA77/f\n" +
            "3JzJANTX43VfH/qsmQ1FTE58PvSCVFfn5SkKwNy55eUOB8DcuWVligIwcWJBAQBAfj568Z1OhLgW\n" +
            "Jnp/POO3JEuQLq41OrKAKSwXDKJEd+edtbWZDEBb29CQwwFw+HBvr5bQhcOoIvz5zydOeL0AY8ei\n" +
            "pDFpEtoGyDuAz+B7tLYA6j+trQHnB/YVI4SoiioK2hrYc7hmRFXR9kCMB/vE48FaHngAS5Nx8PHH\n" +
            "PzE0flIvOnz48ss9nuXLceI/+SQa9aqqGhuTSZ8P4E9/6u4uLATYvz8apd3rtWnCBNyJ5qabysoi\n" +
            "EYBFi/Lz43EAj4c2qtauzzNyeJGIr5cA+HJ2df9sJQOZrUDuBeAJyt8GT1Pe6cQS5K9uaenvR6Cf\n" +
            "PJnJAGza1NycTqMIr6povNO2khLBjkT3ysrcXEUBOO+8igqnE2DRorFjHQ6A2tqiIkUByMvzerEe\n" +
            "mtR6Exofqst70LUiN+WKQnyNnJniB/B35048k+DnP9+92+UC6OtDrwP1G71l8eKSklQK4F/+Zdq0\n" +
            "WAx3NKJ2Z2Pcs2MT0Obbe76tDb/r9ttra998M5HYuPHjxuXHTgAQ+BMn4kA88wxO+YULd+yIxYJB\n" +
            "gD//ubu7qAj99+RhB2CcfvnygoJoFOCf/qm0NBwGqKxEaz0PeDvA5yUCHrD652SSwsgJwbmuNxAE\n" +
            "2X3tNdPd6SgPnFaHD589m8kAvPNOY2M6DbB1a2trOg3Q2RkOa4151BpeZ87NxS3IZ8xAjr5s2YQJ\n" +
            "LhcC3+EAKCkJBBSFeVOYyM4DnRIPeHEAkHw1nznwZav6Xnjh+HFFAXj88YYGp9MYUkz995Wv1NQk\n" +
            "EgC33FJdnUgwW4MVsLMlBKLy4mtsKX7nRx/hX1/+MhKCxsaPC58fGwFoaLjsMo8nGESB/KGHEgkA\n" +
            "h+OOO9avD4fz8gD+8pe+voIC3AAD7cA4NNXVuNfcTTch4BcvRlHf60WHkEi0Hx7wzQEvIxD2vQEs\n" +
            "n6aeldFQW45XEcg9SZFphw4h4NeuPXIklQL48MOWlnQaRXmtP57ngHRdWZmb63AAXHjh+PEuF8Cy\n" +
            "ZTU1LhfA5MlFRQ4HQCCA5Jg3leHfogAaWYyclSRgFbNP5cyX9xKAIxG0Dfz613v2OBwAGze2t2tV\n" +
            "AqotNxfdhQ88MGNGPA4wf35RUSoFgAa60SUE5tfsfVQfu//nP2OL770XjYQYQzGa6WOzAeAqrjvv\n" +
            "7O7OZNzum29+8cX+/sJCgPXrBwdzc1noJRmDLrooP39oCODGGxH4Y8ZggI6qIvCyAb656C+7z4Ap\n" +
            "lizscn777kKxcZDWMOA1cbADBxDwr7/e0JBMAmzdqgc8b8ngA54mTSoqcjoBVqyYNMntBli+fOJE\n" +
            "lwugqiovj9ZMIoGlQBYaSTHQmeLAIKqFGA94RWG2HJ6jU/+IAM5sAfQ0wkS8MyFAKIQqyW231daq\n" +
            "KsDx4/39igLQ1hYOa/uDAo2effbECY8HoKYmNxe9ELhVmfZ8A9L5SZKicG+m9pjbCPTXaBNQFLQJ\n" +
            "4BUz0rLyqprJ3HwzvnP7dqz9oYdGG6ejLgGcOHHFFW73ggWHDycSfv8LLzz3XF9fYeH48Tt3RqPB\n" +
            "IJvQ5eW42eQNNxQXDwwArFhRWBiNsoAPAv5wgC42/sl0fTFn5+9nC3w77kKCjTaf6m9u7uvLZABe\n" +
            "ew0B/847x4+nUmjMo0mirZ0FPOGdyZNLSpxOgCuuqKvzeACWLKmp8XgASktDIW0wDwHemIy5PIen\n" +
            "XF4iEHF4M0lAf390lvE6HMhJ1649cUJRAH73u337tCoTb+K89daammQS4PbbJ05EG7x9jm5P1Nda\n" +
            "/+X3xe/B8xBU9cYbUSXYsWO08DpqBGDDhpUrQ6Hc3P374/FA4PHH33knHM7Lu/56OiKKrMFz5gSD\n" +
            "sRjAbbeVlvb3A0ydiptTaoGmBxxpndbAtgt8exKCuQ3ASCDkEgBdiZ4nXb6nJxpVVYA330SRnjh9\n" +
            "ezsa82QiPfXOxIkI+CuvnDbN6wVYvnzyZI8HoLgYAW8U0K2SOQHQwl0MeHY1XNGfgGBengekniDE\n" +
            "YrjDwH/91+7dOE9bWkQqQV4exh/88IezZycSAHPnFhSk0wDpNLGsbEV7umbPi0V9owogsw1kMi+/\n" +
            "jP1x112oEmBQ1kjSiFWAmppp02bODAR++tOzZxOJ73wnFlNVh+OqqwYG0mmnEyAvD/eNv/zygoLB\n" +
            "QYBrrikqCocBCgqww81Ee71bTqaLW3P40TUO2o0TEEsATidCllabbdvW0pJKATz33N69iQRAff3p\n" +
            "0zjx9CI8b/oaO7agwOkEuOaamTO9XoBLL62t9XoBSkpycmhrERIpMelbI0+8aM3+0t7RiuBmxj4+\n" +
            "kEd7Xyz663V6ehMT/an97DwBmh96AoH3AgFc3HXzzVOnqirAwYO4Mu/UKb1K0NeHi41eeOHECbcb\n" +
            "YNIkVAloO3RSe7SjqZXkiEhrLRZityCVI+Ef72vztfUzFSGdVpSrrkI35W23YW1/+MNI8TtiCWD6\n" +
            "9OnTp0//0Y+w2T/+MTmRJk70ehMJgFtvLSrq6wOYPz83NxZjAOA5vhGQWE4u+lvdH75qYM84aM35\n" +
            "RZy+rW1gQFUBnn9+375EAuDtt48dSyYBwuF4XKvLU6LpXFQUDDocAJdeWlfn9QJce+2sWT4fwLhx\n" +
            "hYUuDRnnAa//a3jJTPTX3jUT/c3ce3Rl7vYzVwFkRjkiJOQufOGFI0dUFeCRR/bvBzB6CSiEfOnS\n" +
            "8nL9Jqv4PNmsaF8CCkQjm1VREdoQcnIcDlwajO1iIcgyUV+sImglCPbc4cP43ddeiyrB0aPDHdth\n" +
            "SwDz58+YUVeXk4Ma6erVeMyzx7NsWU5OOAxwww2Fhf39bLVdJsMAoweOXXebDJhiTjz6qoG9uAHK\n" +
            "dzqxPrRJA2za1NiYSgE89dTu3YkEwPHjXV04QcTGO4pvuOCCCRO8XoBbblmwwO8HmD69stLtxvr1\n" +
            "HF7PobS5IyMARvee9i8Rp+fv6419PHAp8IbxTlYay7OvM0oC7JopW6qK/aOqANEoav2NjT09qspW\n" +
            "I5KthN+9hzYvpchCnuzxfUl7NhKhKCnBTVunT8dNXBcswHgVOlEpFMJ2aSUF7fwjoyLrL5LntBJT\n" +
            "bS323j//M+6Q9f3v42al2e9ENGwCcNFFweDg4Ny5x44lEj7f9OmXXZaXNzAAsHx5bm4kwhZ5kIgv\n" +
            "N4bJ/e6i57QA5I13w1UVslENZN4CntN3dKD//emn9+xJJADWrz9yJJkEGBpCnZTXQQkmNTXFxS4X\n" +
            "wM03z5/v9wOsWFFb6/MBhEI+H3pDGJz0xkR9YJB2ohpz7CQeyOJ8Blyxsc+oApBoy1v5eYLArP96\n" +
            "jq4nLMxyjqL04CAuRtq+va0tkwF4990TJzDiEdcyDAzoA4RkSRYJyRMECrzq68MNR3p7cc/Io0cH\n" +
            "B51OgLfe6uz0egFqavDkpeXLMVT9ggvy8mIxgPx8WqTEvl87n1ivsWs2nl/5CpK9l1/G1mzZkt0Y\n" +
            "D0MFSCavuQbA49myJRoNhR59NJ1WFEW5/faxY/FgCq2ILhPd9cDSX8vL8YCUPTf6qoKZcZBtOYa/\n" +
            "u3e3t6fTAI8+un17PA5w6NCZM9qFq0yDxYENBj0eRQFYvXr6dJ8POX0gADB2LIr2bJLzXgN+Chuv\n" +
            "uaHOUhKQc37RfWtjn1j0l/n1jaK/ftENifTxOBLU3bvb2lIpgJdfPngwmQTYswfXNtCqRN73km3y\n" +
            "eJCh0TkNRHiI58bj+n0L+EVS1BskMUyZgqtUL7+8uHhoCOD883NyolHaPwAlE5mXQG8czGQymSef\n" +
            "xHLf+Ea2B5pkLQE0NiaTHs+SJRUVbncyedVVzEpPq+yMgSzmnN6qnJXEINbRjaJ79qqCiFDwIv7Q\n" +
            "EE6B116rr08mAZ59du/eeBygp4fcdXpOTxNj8uTSUpcL4I47Fi8OBgEuumjKFJ8PRX9FYUYl+k76\n" +
            "CjapjARBfJ8lexAQ8XpjPuNEvJ+fSup1e14SIE5P5ZgpkNpqFL4xXgGfb2np6UmnAZ55BlWqjRub\n" +
            "mlIpXLyEKgCxCf338uSHQp4p8TYBGq85c4qKMhmAW26ZODGdBqDt5JJJlAG6u3EtRWdnNKooAE1N\n" +
            "g4MOB8CRIwMDTidAZ2c87nAwgnTwYDiMx7EPDeXlAXz4YW6u1wtw882lpYOD7Ph0ZtLU40pV6YQn\n" +
            "VVWUq65CSWDJEiyLx6fbSbYJAOoaGGQB8I1vYFMKCnjA835uu4ExsnJy67rcGGelq49ENcAdCgDO\n" +
            "nIlEVBXgscd27IjHATZsOHo0mQRIpfQchwbQ50NgE6f/ylcWLQoGAaqqiNPTwBoJqGgCGB2DDChi\n" +
            "W4C2hPZ5Bg3+L20Jxu9lgUC8n5/p9lpCIQrw0Yv42vWB7H4qhdr55s1NTckkwJ/+9NFHsZjRliID\n" +
            "PLW+sNDvVxSA+fMrKhQFYPHiykoAttz51VePHdN+H9Xb1DQwoChs1ePkyegloMhB3q2XTGJ7iTAc\n" +
            "O4aEYPPms2fdboBdu/r63G6mOmze3Nfn8wGcOBGNulwAN9xQUjI4CLBsGarUHg/OKLIZ6Me5oAD7\n" +
            "9RvfQJxu2YKSAKo7o0IAcErPn48TcNUqo3/bKjBGNqHtPmeeb/2cvWW9VsA/dKizM5MBePjhbdti\n" +
            "MYB9+06d0ov4euCXl+flOZ0Ad96JnP6yy2bM8PsBfD7kPVpd3pxw8vcZxK0IgmxEZSSAh5A+z9zY\n" +
            "xwNea6UnOFN7zYCvKMjhBgdRxnr6aQT8yy/v2xeLyb0mvEWipCQYVBSAZcuqq51OgJUrJ0zADeRx\n" +
            "eTLtEFRTg/sSfPQRjifvJiTO/tZbbW1OJ0B1dV0dEQqtm5C+jlRDWpZeVub1JpMA8+fjXpNHjw4M\n" +
            "OBwAGzagjWDz5p4eOjrO7Qb44x9PncrPZ4fD3nprcXF/P0BeHrMZaCUB7NdVq9BtOH8+9oK1TcBp\n" +
            "VaChYdUqt9vhwAn5wAMIkGXLeMCY6djk1pPp8CJdXa7D2y1nbQsQc36x7WHTppMnUymAX/3qgw9i\n" +
            "MYCjR7u6aAsxEajmzRs/3uMB+Nd/XbUqNxfgooumTvX5AFwucjSJJRR6v7Z9/K+2XaJx0F/rCav9\n" +
            "X+NzesIjlkz4X+N9fU/xtdFXdXYODKTTAL/73caNkQjAmjX798diAIkE7mMgc5f6/ailX3wxhjrf\n" +
            "d9/ixV4vwOWXT57scgGUlYVC2vel0wgkWtVIodX19bjjEU9Oe3uRqy5YUFamqrjRjJ54Gm0lxLlp\n" +
            "FqoqOxlq3ry8vEQCYPx4tKGdPZtIOBwAnZ1oTDx2LBr1eHAXa4xP8PkSCbaXoVYyAwgEMCcW+/a3\n" +
            "a2ocjnXrfv/7xkZ+4VdWBOD++6dMcblqa7ErfvpTnBB5eSIgySZkNvnyOACZUVBsbBRFEPIRhmbP\n" +
            "oVgJsHbt4cOpFMDvf791azzOVtfxATqku1977Zw5fj/Ad75z6aW5uQA1NSUluP+cMdKRJ2B6oOsJ\n" +
            "gaz/zCISeYIwEgIgU+FEgBcTBj3k+WvimE1NnZ2pFMB//ue6dQMDAJs2HTumFWR5QDKbCkZC3nvv\n" +
            "hReiMXXOHI8HoKICFz1pVRRtDYzw4G9hIS5G/+ijU6fQa4AGNeoF2l8gPx9XT86aVVQkipOQB0pR\n" +
            "HgV64fW4cUgA5s3LzY3H2f2TJ4eGXC6AEyfw3IrGxnjc4wGorkaJoqjI5cI1M1qjbFkZ9tO6db/7\n" +
            "3fHj6bR870FLAnDffZMnO5133okT4cYbZZxJBKzhcX6Z94Cf0EZOyddvXo4nNFiOrLnPPrtvXzIJ\n" +
            "8PjjO3YkEkaRkyZeQUEg4HAAfP3rS5aEQgB33HHBBaEQQG5uIIB+ZB447Htl/SFSQcwkA62x00xC\n" +
            "yObXGvAyW46Y08uAT/EMx451dCSTAD/72V//2tcHsHdvSwuuINUb6Wia4+lQLDDqu9+9+OJgEGDu\n" +
            "3DFjXC7tOQ1i7qdVabT5eXkIbNpA5cCBs2dJRdG+nwjDokXl5aoKEAzSYnYtR7Z+H08egkHk7DNn\n" +
            "hkLxOO5XkMmwMyhbWpAAHDuGvyQRFBcjIcAW5OVhjSdOIAHYti1rAoB79uXn4wQgzj9unIxTWxMG\n" +
            "u5xfDujsCIbcvai9Jt2eTqZ5/PFdu5JJgOeew0g9Ejl53X78eFxd993vIqe//PKZMwMBrYgvty3I\n" +
            "vjMbVUAUD8ETBJGRlG8XbxPhbTEsV+Z90dsk7BIE+rqjR0+fTiQAfvaz117r6QE4dKi9XQR8nuB+\n" +
            "4xtLlgSDAF/9KtpWiopCIRS1WYiwHnhiIPL3necQEQrhjkbbtmE8QTRKK1bwCTqAZPz43FwAtrch\n" +
            "7zwVqQR8O7RGR3qegpAmT8YAoqoqjyeZZDaBkyeRADQ1xeNeL8Dkyeg1KCrC0HusJRC4776JE53O\n" +
            "V15BQmA8qcgB0qQoAAsWYMPmzjVqa2JRT26sMv81ipD2FtXIjXm8UUxfH4mcRMn/8Ift2xMJgJde\n" +
            "qq9PJFhEGA/8mTPHjHG7AX7ykyuvzMsDWLoU3XfGgCGecPEclhf5ZaoAn6+XWBihEOeP9q/Ze8y/\n" +
            "C3+dTrx//PiZM6kUwM9//uqrCPy2NgS+WMSvqsK1Dw88cPnleXkAN920cGEoBOD3487/tCbALHLU\n" +
            "zB1M+XT+Q01NQYGioLcAA7D06KB9GTZvPn3a4WDnFzB3rXHeZYMHHkfnn4+BQ/fdN2ZMXx/A2LGo\n" +
            "Ahw7Fot5vQAPP3z2bHExwIkTyaTXS29F3AIsWCBDuQkBAABYtQorCAazAby+A8SEw/6qORng+dAO\n" +
            "c07GgI8TlbaM+v3vP/wwHmer72QHUCxdOmmSxwPwox9dcUVuLsC0aRiSazwKTG98s1JlmONKFoLM\n" +
            "qwy8asUDlFclZIDmJQcj0HmVxM57tRKM9jucTpSMTp3q60unAX71q9df7+4GOHCgtRV36xVz/Lq6\n" +
            "ykqPB+AnP7nuusJCgOXLp03z+0XzQh7CLb5vPk/IprNiRXU1IkC7XxWbbYcO4fkHjY1o1SfGIp/H\n" +
            "egIhWh4uwg+pkrNm5eTE4wD33ltZ2dvLCMHhw7GYzwfwyCNdXcXFAGfOpFJudzCIo7BqlW0CgKJ/\n" +
            "SQm+eOVKayDSk+YUzIxzj/R5M0mAB/7AAK76evhh5PhvvXX0KAr5+kS1XH45+u0feGD16txcgHHj\n" +
            "ioowCETMScyALway2Ognt6VYGQfFQDcC2vzXuj5zgkT5DgcCv68vGs1kAP7f/1u7tqsLYNeupqZo\n" +
            "lL2VB/6cOdXVXi/AT35y/fVFRQCzZ1dX+3xagmu+JsM4D4wMR0+I9eNJgJs+vbTU4QCYMqWwECUE\n" +
            "PYMgCXL79jNn8Dk2Y83mtWzeGyVh/X36/tmz0UZwzz3l5T09ABUVqCIcOIB7aj71VG9vURFAX186\n" +
            "7XSuXNnefsUVTifu1GxKAKh6fOmUKfqmWlOqkX6g9fNWnF8vSRBFpu2t//CHjz5C4B87pgU+UXbi\n" +
            "W9ddN3u2zwfwv/7XxReHQgCFhaEQnSIjA/ZIQ43FkoIR8CJVwKgiiMtl8yuqRyRRaL+LAR/v0/bj\n" +
            "jzzy1lvd3QDvvVdfHw7LRf1582pqfD6AH/7wS18qKQGYOLGigk58Mu9nNj/0BMquiijmuDk5aBS8\n" +
            "4ALcDJUPNKK0e/fZs4oC0N+PtgHehjLaDJIIzZw5SAjuuKOkpK8PjYbpNMDmzZFIKASAO3FNmdLa\n" +
            "mkp5vbNn2yAAABhSaBT9ZQ3VXmkJiQzw2RAGkchm9bz2uUgEJ+B///fOnckkwLp1eo7Px2jffPO8\n" +
            "eX4/wN13L10aDALk5Pj9qGOKJQu5iJl9qDEPPLEqYG10FYv+5iK8rJxRBRC/j28frY144YXNm3t7\n" +
            "Adas2batr89oAyfgL1gwaZLfD/DDH95wQ1kZwIQJ5eU88MWSljmnt5LQZIyFr3/BgspKhwOguDgQ\n" +
            "wHmjXdoE0NKCJxY1NmLEIDEeu0C3xpl+1lM5mpdLluTm4pZ6RUX9/SzeYMOGcDgvLxj85S+7usrL\n" +
            "L7lESgDYST0AABdeqBXxxQ3lm2T+QSLVwe6HiyihGSFSFNz6SVEAnnpq375Uim2eqd3rTQv8L38Z\n" +
            "V9997WuLFwcCAIEAGZesVAwrXVN+bS4hGEVuM4CaGe1EQLabb1Uv307S9TdtOnAgHAZ44okNG7q6\n" +
            "WMw8jSIT9SdM8PsB/u3fbrihvBxg/PiyMtotH3vdCsB2Q8vlHNbsPql6Y8fi9ugzZ6JKwJ8qTV6k\n" +
            "Xbtwe3KtKmDGCEX4ykbS5m0SV16Znz84CLB6dW7u4CA7V+PIkXjc77/00gsvnDWrtraoyEAAMI0b\n" +
            "hxVPm6YFuP6XAdKKQvEAtgd4+x2gv6JYabzz4ouHDqVSAC+9dPAgHgAh3vjhllvOO8/nA7j99oUL\n" +
            "zUJ0RSKkjPOYiaTZLz+WB0SJrPNmnF+vCsiNgLzozxMGUT2k6x892t4ejwP87ndr1nR0APT1DQ7i\n" +
            "KlFsHXOjlpZipCQCv7paJuprR9gO4RVLBmw2Gp/Tzi+ZJEBGwQULKisVhTEOPtXXd3ejyoluQ5kI\n" +
            "b40HIwHRv0lfDxEcrxdDg2+8sbCwrw9gxgy/PxbDe6paVVVe7nIlEhUVAgKgKAB1dfgaMgIagSwi\n" +
            "CGKAmhMQq/IywiDrUPpdt+74cYwdR85PB2DwwL/ppjlzfD6AO+44/3w98Fnt/ETS59tbtSgXRe2p\n" +
            "BqL4BZ4wiMvzoc3DdfuZRyAqCvZof//QUCYD8Pvfv/LK6dMAjY3t7dGodrk09mwohCrV3XdfdVVZ\n" +
            "GcC0adXVgYBI1JdJVNYEWQQQO5KAbF4BsBj/GTNKSkgV0H4XlW5rC4cVBaC9HU9D1qoCVngZDXxR\n" +
            "PxYWYmDQl79cUNDTA1Ba6nanUoWFOTkORyYzdaqAAAAAnHcePo5n94lebyaa8+WtOtoc8PL6teWo\n" +
            "g7dvb2/PZAAee2zPnnQaIBLRU2AahuuumzHD6wW4667zz/f58KgrLfCtFjXJJ5A54I3PZacamIVe\n" +
            "21MBZLaB7Mrx5UkUfvbZt9/u7ATYvHn//v5+7cTX9+pNNy1fXlwMsHLlvHl5eSI3qhXwhzceMuOf\n" +
            "aJ6K5iNx2LIyDDiqqysuJolTOzvDYZx3dESZkUHIOb8I6FqJQFxeLClQv06bhhLA1Vfn5vb1uVwl\n" +
            "JS5XMjlnzt/GRb/Md9YsedOMFElEEOTltaRB/JyIMMgoMk3DI0e6u1UV4OGHd+5Mp/GcetE6/FWr\n" +
            "pkxxuwG+9jUEvt+v5/j2J4R9Y5KYU/GqgrUXwcy/zl/LRHTRIidRu8yMgdrypOtv3rx//8AAwLPP\n" +
            "btjQ2cki8SjRXniLF8+YkZsLcPvtq1aVlgK4XCREyyQk+4CWPWdnXK1Fc/28pgNq5szBsxB5rwCp\n" +
            "mgcPYnwA24Y8W0l4uDgzlgcAWL48FBocBFi1KhQaGJg1q6vriisUxes9F7JSWIiPVFeLKIy2aiNF\n" +
            "EjfPWF4suBgHyvwDibOcOYN7uz300K5d2jPv+Fj9JUuqq10ugLvvXrzY5wPIycGtteSivrVIaMYp\n" +
            "7BIMa1F3eHEDRt3ZXAKxvs8ASEY+pxOgpeXMmXgc4OGHX3ihrQ2gvx+1XsaBsIcrK0tKvF6Au+/+\n" +
            "0pcqKwEKCvLy3G7tLrv2dXr9PDEHstU4yjixbJx5VaC2trjY4UA3IebrazlxAr0BAwN4AIl8nohQ\n" +
            "pscZP69AkIzl9cikzUzHjfN44vHq6q6uTMbtLiw8pwJUVeFj5eWiqkXVZkO5jJ+W/XMOB5aPRtHa\n" +
            "+qc/1ddnMgD79585IwL+7Nl4mOV99+HqMNpVl+f4ZqqJ+YSyEk2tOJbsOTFARZxbDHjx+9hvdvn8\n" +
            "+2MxtOb/z/+sWdPeDtDQcOIE+vVJ18fe8XpxWe5dd111VUUFwIwZEyeGQnJdXyZR2e3nbAi2bPxl\n" +
            "orZ2ZhDhqqzEY9DpOHTeFtDVhXH3HR24qEg22+1LxNbPyfCjTdh+wnlV1TkCMHEi/ublyRvEv8Du\n" +
            "h1g1TPwhPNkgwZJ2bHn77ZMntau0mHU5P9/hALjvvgsu8HoBxozBo6+MuqaxXSIRS0YY7HIQ+YST\n" +
            "2wz4UGJx5J3M2Ghsnzmnt+L8+EsA37Bh69auLoA339y8+exZI3Bog49LLz3//KIigGuuuegijD/L\n" +
            "Tqc3AzQ/SvaAbi06ZwPEUAgDhKZOxVOSeQlgaAhtASdOYHyA/Hus8JEt47TzXF4e/k6c6MBiGO+M\n" +
            "xj9xt/CvsCYPPGBkzZO9kSYe/n744enTAADPPdfQgFtEscWPAGyrp3vuWbTI4wGorcX14do91fi3\n" +
            "iAmPWAKRlbcjWso4HN43Ak6bb5QY5BPeHsCz+6WIvqamtrZoFODRR19+ubUVIBrF3e0YAcaerq4e\n" +
            "M8bvB/j617/0pTFjAAKBQMDlEvWXuB+y/z59vTzHlovO1pzfbF6SAkYEgLxLlMgW0NSEZxPSxiNy\n" +
            "nBjz9e034kTcTjZfQZAYzhH35xpNur/DYcbh9Q2zKxnwH2Sk4aLnaXq0tuLxR48/Xl+vqgD9/bQ9\n" +
            "BN73enF63XXXeee53QCLF48dSyG74vfal0RkHF5b3mzC2eFsMk7NEwwtxzcOtnHCyCQC+78k8sfj\n" +
            "mQzAo4++9FJLC0BjY0tLJCIS+dGoeued11xTVQUwadK4ccGgdnmsTOQ35/hGgiojyLJxsuKg2ZbH\n" +
            "RF81fnxenqIYFwtRam/HrcWsjYFmkBa1l8+RSTaitzj+hvtzf4wbZ+dFsvv2AGbV4fQ3XlFk1ZNP\n" +
            "HjoEANDY2NcHYOQbV101ZQoegom/1u/Vt0BGzuwTPDFhkE9M8QSTAUBGmKw4vkwSMXJgsQhOAH/7\n" +
            "7W3buroA1q/fskUk8hPnX758wYKiIoArrkCRX7TXoZUoLAOyXaDL+tfsrrEme/OWbAGlpbjnYEkJ\n" +
            "HxeApWkvQdo/wCgFDB8v5u3lS4vSuHHnCABqabKuMq9GLmrYayBfHn/feANPdX3//bY2AKORb948\n" +
            "jM2+7bZZs1wu3CHGrGNk3SfrUJEISPmiKSgnE9ZAYCVFnF8uMYhbb0VAWD1ka9AaEWnVZGtrR0cs\n" +
            "BvDYYy+/3NIiEvlxqldVlZX5fABf//o//dPYsQDBIC/yW4v22u/LRjSXEUS+/+2Mt7WorS9JnJ4W\n" +
            "C1VVYaiwfhNvJrH29KBR0PhdsmR8r+i+PFfMYPXXJSXnCAAZBfQv1B/8YNZM41/a8uaEhKY7TsMD\n" +
            "B/Dwxr/85dgxRWEbc7BDMbGjv/WtuXOdToCiIj3lFbVweCJVdhxB/pxdyULOsey0wGyiiER7Y2sx\n" +
            "P5kkyevVV1tbAY4e1Vv5KblcqAXfdtvVV1dVAUybNnFiTo42DkAuatv97uH1r3FczSU4WZL1uz6X\n" +
            "tiarqsrJEZUiSfbsWZQErOTJ4eMIkwgFzOXK38nL0xAAJtqIP9VcFzLvJvlA0N+0QcdTTx0+7HAA\n" +
            "dHXhEU9UIhBAHeuOO2bNwvXZaHxhMf7mqkV2OpI+NxtRS/Rt+oG3fq+YA8rKm4vMZqoAcX5tHMHW\n" +
            "rXv29PQAvPbaO++g2VWf0mkkxRdcMHduQQHAddetXClyHmt7PRvgyjm8eFTNxkFGgKzGwUwS5hOR\n" +
            "xYoKjBCUBQbR+QDWLRfPIT7J9/kVt1/r/mZ3/kYAcCdUqyTbZ81uEu21Q3W+/vrJkw4HwJ49uK6a\n" +
            "Xy9++eU1NYoCsGzZuHGKYtyiKZs03I7WA0v8jN7WK3ovD1BZ6+zm2/1KmQiOPd3b29+Pm6C++OLJ\n" +
            "kwD9/RjUSqVJwiotLSz0egG++c0bb6yuBsjPz8mhwJ5s2q8FtFEZsN+vWgItEtHt9KIVaTBL9J7y\n" +
            "ciQAdCYmJZ4AyIFrrDPbJJLczZPff44AaN1/9rshG92ET0Qp9+/v7nY4AF599cQJbWw5ifwzZhQX\n" +
            "AwDcfDMuVKITUsyhZj4NjYdOiTpNXrv+aCsZITF/3n4/inVQbZ5IpJarBFRWb2t4/XXk+Lt3HzzY\n" +
            "18d269WWx3G44ooxYwDmzKmry8tDiUDbYqPEZEUQ5f3Cf7/ojnYcrPb/5cvw4yZ63no24zwsLkYm\n" +
            "SpIqr5J2d8diKLHKWJc9ycbOHfu4dLsFBMA+/RCXNH+eOrq/H0Mkn3uusdHpxAMXtEpIQYHPBwBw\n" +
            "113TpysKQGkp7lUwEs4/mt8h69LRe//w60ECZVUvArypqbk5HAZ47rnXX29pYUdwUSKRf+bMKVNy\n" +
            "cwFuuGH16spKvYQ23PaP1nebj4P8LaPxfqqDdhGmw175uskYyC9LH43eslejqNTfCEA2dsnRSevX\n" +
            "4/nre/eiBMA7o665pqYGAGD27NJSOgopmw+XGUP0WzBbf5uM8xgPfuD/NtPS8L75wOn5mhbQ5kAX\n" +
            "lTK2J5XChdJPP71mTXMzwMmTbW16/z5tLO3zOZ0Ad9xx3XXjxgGUlhYV4bp9Y/v17THny9qnzFVL\n" +
            "0bEa7I52HOyodDI7lmxeWLce/1E8Sm4uEgI+kTFQT15F4/ZJJkU5RwAwbFFebORNpdCD48dx99RX\n" +
            "X21udrmMVv5Zs4qLVRXg6qtravhVfUYzpb2O1E8wMfBkwDVOBjrrLjvJQQsMc4Ihm/AjnyDa0Ont\n" +
            "2/fu7e4GeOON9947fdpodCSAX3zxokUlJQDLl59/fnExC/W12//ZfN9o9au4Djkh0b4fQKZLy57E\n" +
            "fNL9iQDwddEaFhYQJP/CkdnYWLKuJ5nUEACjiU7boex4Z9lLjN1FoFVVPBZZUQBeeqm52e0G6OjQ\n" +
            "u0Xy83FV1Ze/PHWqqgIUFvp8/EEL5jzFCjJ2Oa74+4dPeIyHacqe499n/p3yXz2h0tczMNDfn0gA\n" +
            "PPHESy81N+OOPSJjX3l5cTFumHLddWPHavfftydhiPrdXn/y3zH8cRC3zL5EIn5C/DzZtPCQb2Oi\n" +
            "Y8HpPAE77zeT8OQSjrjfxDj9GwFgp6/JxGLr6WvM0xqiduzo7nY6AbZuPXvW5TI6K1avHjcukwGY\n" +
            "MwclAMZnrCeYec7wgWvvvXyHywAvBihfnj+G22xCWE0U7fM0Md54Y+PGjg6A7dv37evpkRv7rr9+\n" +
            "1SpcxTdpEvn37b5f9H2iaWnWD6J+48fHLiEZ3XkhvqI+JCMgn59MIgGQGQFlb9NiyI5qImPS4vLx\n" +
            "+DkCgPH29iayvQ6ml/b2orHvlVdaWz0eJgpR7RMn4jnrV189fnw6zY5EsuYTYkovO5tNVFo2cc0G\n" +
            "RMtRxcAdfnkZQRATJDGg+PIE7+bm9vahIYBnnnn99dZWgGRSz4sI4HV1GNBDxj6tZCCeFzI+bSwn\n" +
            "VoHE88j4/HDLi/8yqg7W4y6ab6yfMQ8tJsbEe7fM3sh/r2xm8d8lKmUmswEMDp5bId/fL+oy84pl\n" +
            "Ofqrt9/u6PB4ABoa+vudTjahSGe6/vrq6lQKoLzc79dzfvsfNNyOkHWLvrwYwNblxUAxAok4K5Wj\n" +
            "HtDfl4v2YqDRP7LqP//8G2+0tQEcPy5ezOPz4Yjcfvu111ZVAVRUFBejsY/s1rL3yL5b/B2y7zQj\n" +
            "dOL65eOXbXnZc+bziV1pRWy/H42BvIieyaC7kHkBsiMEoy/pIu7P0a2entHSrQjgra2RiMMB8Oab\n" +
            "p097POzDqXsXLiwpSacBliwpK6PjjWXvzRa4w31OPxH54RFPMNnEFXGYbADEjG3ia6vnSSc9cODo\n" +
            "0YEBgLVrN248c0Y0MbHepUvnzy8qAli5Eo19lG/sgY+v3fpx4yU0K0JqJQGONkEQj7fHwy9J00tQ\n" +
            "/JZp9t/Hv9esJWZJe7+nx4FZbW32RV79MPEvJB1n3bozZ7xegFOnYjFadAIAkJ/v8agqwJe+NG5c\n" +
            "MglAS0e08LILRFn5bEVM2YSQAUBcTk4QRO8zAoNxSHE5um8NKACAWAzNTs8998Yb7e0AnZ09PfG4\n" +
            "0dhXVJSf7/EA3H771VePGQMQDPr9qIbRVGXv08+H7NrJnjMnEDLCIJc0ZONhDWDxvJHNM3vzxmic\n" +
            "0zNGoz4uhy9PCEX12mmn6G34d1vbOQng5Em+Y+SPiikMbbd17Fg47HQCbNx49qzWI0q1LltWVpZK\n" +
            "AdTV5eVlMlpOY1e0M/t0falsAGw28fT1mQNdDmgxcGXljICS3dfXRzr/Rx/V1/f2Arz33vbtXV1s\n" +
            "YxXteKgqwBVXLF1aWgowe/bUqTk5AOk0OWb1wLMP/Oy+Y/j9ZkWQshvn7AmIFV70ifqerRWwwpns\n" +
            "PdbzXnxH9L6TJzUEQFVVVRQPYC0aqSpAPI4n8axde+aMzwfQ05NIaN1GFRV+fyYDcOWVY8Ykk+zo\n" +
            "Ih7e2s+zGlD+s7KbAGLRUjTRsp1w5pKAnDNmMvr7eG28r+XMfH2DgxjD/8wza9e2twMMDODhaPwy\n" +
            "3rFjKyr8foAbb1y1qryceQPkgJdxeHZN7dK3m76DlefvywiaqL+HT5BlgJdx9uznl76cXhbQbudi\n" +
            "l/DI8Cf+PvuEhMX9nDx5rjlNTZgRDtsHIn0Y/h48ODDgcgF8+GFvr9fLJhx9+KpV5eXJJMC4cYFA\n" +
            "Oq3VhexS3OGJeMPlCKy8kSPpn7fSeWUisZXIzN8nKwoPOFS6HA58buPGjz7q6gLYvh335+fdfCQJ\n" +
            "XH/9ypVlZQA1NVVVfj8a+/Qiv5HQ6AkQljcSJGM7R/Ld2fQzXfGSxPDGXcZxzeeh0XKCV/zm7cT8\n" +
            "jPycJ3zm+ONnO98uMXkgnDc1nYNvczNmdHVZA0v/SgpwWLfu7Fm/HyAcTqW0oaRjxyLgV6woLU0k\n" +
            "RIEKMsHGnGNnwwmMXZvdxJBxfPNydnV643M8oPSclQFQ+9zZs93d8TjAc8+tW9fRARCL6c9EYm6+\n" +
            "CROCQYCrr6bNOvXvYUCna3q//ppvh1ECkBEUo+RjJRmNbByyBbyYA8vew+fSaci8qY/cgy4XBS+L\n" +
            "56UZ47NX3vic8bsQ5wDNzeeE9LNn8VZLixmF0b6YOH99fTjs8QDs3j0wIOL8l1yCwC8r83qR81t/\n" +
            "kDnFFZezJgi8xGFvIvH1WksCRolBJALLAW8EvoxzagG3bh1u2XXgwPHjg4NGzu/x4EEcN9+MIn9Z\n" +
            "WUGB2w2QydD2quZAl3F6uUpiJCx6QIv7Qa4qyGwfPOcXj1s2hFtUn5wD6+slAsAnv9/pVFUA3Czd\n" +
            "yKi09YrbK0aLdXkeH4hzwr2jtnb9+lQKNy4EaGiwAhq9LhrF0N5167q6AgGASASvqfT48cj5L7qo\n" +
            "qAjjDI2UaHRFNGM5c6CLJ5KVKG+sz5xzya32YkBb69YIKJKk2tpOn47FAF588d13Oztxt2TteNFq\n" +
            "vgULpk3LzQVYsWLevPx8gEwGA4FknJ99LyMIZhKJXFLhCZu5DcOupCR7zkp1MDICmSRmnIdm804r\n" +
            "AegZE/76fOjtcrt5CcBc8jBCeLjltThuaCDcu7QPAOzapXdUMIGdmk1GjAMHIhGPB2DfvnBYy/mJ\n" +
            "61xySXFxLAZQWurxEOdHd6CsI9kH6Rf96AeCtQjLifL5evjnZfnagWT10QSh72MhsQhE3FGHJpox\n" +
            "fJpy2HOUi0Dh92ImoxntpUd9TrWh7JXJYLk1az744OxZgKam9vZYzLiaLycHHa233nrppaWlALm5\n" +
            "eDhnOp1O649N5acsP5FY68wJrxGAvDuRB7hYQuABLbcZ6AmKjBBYSwJ0JRaxzQkDqVh0JiWfgkGX\n" +
            "S1W1xm97Rk8zRqkvL2Os/NgSzjG59AXq67FAby9WUVjINySRQGv/e+/19gYCAENDyPkpjRvn96dS\n" +
            "ABdeWFBAe6DIPki/rNYc6LIBUBRsD9XEgMiu8S69SQxo1hK+PvYeag21TzvhGdnUi3jsOXY4if5o\n" +
            "MiIE1CI6+IP1Cj6n31zz+HE8hnvt2q1btWFc2udUFWD58rlz8/IAFiyorQ2FANJpikoXJ16w1E4s\n" +
            "Hgj6CWjXaMfbAuQSjxioRm+JWPIyPqdvvxXByE6SIMmL9rngU0EBxr/Q2IvYnx3JmAe6UQKQSyqI\n" +
            "a8K5gQCoqqqeOIFTqLERJ2RhIX0MNfzw4WjU4wHYsycS8fmMi3qWLkXgl5a63TLOL/tgK4IgIgSi\n" +
            "54cnCcgIBw0YTzB40CDUVTWTIQCLOLyMEGh3vqHntICn61QKCdSaNZs2dXcDnDrV3Z1IaK3LWGNx\n" +
            "cX6+281O46XQa2btt1rmzV/Z54hmADPzkshsCSLA85KB3fdlw3mtgKnNj8dR9x8cTCREfVtYyAgA\n" +
            "AJpOzYFsBLoZYTC2X99K/LuxkeH8HK7pD9QJiJds386/mMJDNm7s7w8GAQYG0mntERVlZSjqL1mS\n" +
            "n0/bH8o+QNzB1hFhogGQl7PrnrN6Tjzh7Lu3zHV7ke6M5ZiRDScOvufIkZaWoSGADRt27uzrk4N4\n" +
            "1SrU9adNGzfO52Ocn9fltb/6fL59YqOgyEug/37+mvcy2AW+XbfhcMfV7rwRz7t4HHV/Oh6cErn/\n" +
            "Cgu9Xr3R05oA2QO8UUITESjCNcM5RwD0adMmfCCZpInX0hKPu90AO3ZEIoGAcYni4sW5udEowJgx\n" +
            "Hk8yqffz2/1AfmD0+faNObIOsMspePcV/xwvwor85dYTWuYvN7rZMhmAZBLdemvWbN7c2wvQ2dnX\n" +
            "xwf4AABUVhYVud0A1113wQX5+YxwyKz6MkAbf/XtEREEc4DLvAEyAmGlGhjdimbjRuOafWQiP0/F\n" +
            "EgRx/khEfwAIHRlGEoDVPJUxSDMJxbocEaVNm3iku8CQVFVVd+7Ev1tbcRVTTc2mTYODoRBAd3cq\n" +
            "pV3wmJ/vdGYyAEuX5uVFo3odx1zkZvlWIpdItGfP87o50+lp2Em01xIirTEPSzMbALWGxG6cOLR9\n" +
            "tvG+7Npc59fvYkv9w4x/9N24XfeBA83NsRjAu+/u2zcwYFS96OrKKxcsyMsDqKkpK/N4tG4+VtJq\n" +
            "Dz1exdH2m2ic+Pv2CK4VB7YmqOJrVq+ZcTF7L4O43TQvu7ujUVVlW39RIuNfUZHHI46AzE4iyF70\n" +
            "V1VVbW3V49qEAOCHt7Q4nU4nwJYtp08nky5XTc3WrZEInvWmf8HMmcFgLAZQXe31JhLY7aS76jue\n" +
            "6db6+zzQjUY5GaDNCYfe+Mfr9FozHj4vJghUq5FgGHV8K52frPNiY5/ei0LX8Tha6195ZevWvj6A\n" +
            "7u7BQdw3gXkDAAAmTEDAX3nl/Pm5udheXGuh/SLWJuvEEwJ+4vHlxP1vXzWzNg7KgG3O2cX1yQmV\n" +
            "PRWA/+3sHBpSFAAKv6L+yc11u1UVIC/P5aK1L2bzlW/PcFQFI0HYsoVwzY+yQQWoq3v77XQao/kA\n" +
            "1q3bvDkSCYVSqY6OVMrt1m584HCoKsCSJTk5Q0MAuHbcToOsKK2Yshk/3IqzmA+8lT86G9FeNkFl\n" +
            "gTMiUZm/djhwSuzb19Q0NASwadOhQ3hCj55/k455zTULF+bmAlRVFRS4XGxRj1ykH+4vL9KLbQnW\n" +
            "cQJi24c85NnKJmBXVZCVtyIE4nlG7r+OjqEh/SzD8Skq8npVFSAQwEAgJhnbIywyHJlJZOyXNt9Z\n" +
            "t45wzeNdoAJgeuutSCQvb9u2DRvC4by8lhasFDfqBACYMAE5/owZPl80yhaZMBGbNUTkr2cc3/hh\n" +
            "WklAK9rbc8/xVno9p+f99Vq3Hm/Fp6fsivokXZi58bBF2u9kfnu6djgAolEM1HnllQ8/HBgA6OuL\n" +
            "RDIZLefH766rGzvW6wVYtWrWrFBICziSXLLl/PrEJpo2Rzzx9OVlE9aucTa7uAH718ZFVuaANLcZ\n" +
            "kPvv1KlIRLT1VkWFz5fJaAOAjIRF248yYIv6VUwYtCTo+HHM3bxZNr5SArB+fSSSn9/S0teXybhc\n" +
            "GzfiJMKtugEAFi0KBiMRgNxch4MW99C6f9HAE1CzF+2NKgQDkVZ01gcZiwJ3zJ4z3mfXdkV9vjyp\n" +
            "Onp3H32Nw6EdPpKtHA7sqV27GhtjMYBt244eRduK/lhwtxsjy770pQULcnIASktzcvBgFf3G01pb\n" +
            "w/CSngBor8wnIgOKeCLb99JkK3llRyhkhEBmq9C3MxJJJFQVoL09EmGzmUlq48cHg9qt7lIpqwhT\n" +
            "q8hEK+O4dnzeeKOubv36VMoo+lNyyG689tqePY2N6OpT1TVrMDcWKyx0OlMpgPPO8/sjEfOG2tFh\n" +
            "Rs89x/LNRXurAbfvljJ3Y+lj5UWirPaafiORaBR1/h07BgcBBgdjMZIwsFYsPXMmcv7ly+vqcDUf\n" +
            "L/LLrPrZegHEIruZCiBaJGT0Ipj3i2ixkV3VwK4XIRvVkc0rvSRLR351deHJPzROXi+qyFVVfj+6\n" +
            "X63cjTLOPxxVoa8Prwm38uSyKoAftG0bfnx9/bRpXm8stmBBZaXTmUgw0VXbYJERUCuiY2l9RJ28\n" +
            "HHFTvZWedRUvQbB79JxVgE42ATvW5fXWfHpGUTAgCv/XKiZ4Tbr8zp2NjfE4wM6dJ07E40bO7/fj\n" +
            "yTPXXz9/figEkJ/v8+Fec/x+s+yIMG0/2U9GfmJHFWBlrG07+nE35/x2OHa2wDcnHDK3oT4u49Qp\n" +
            "3PouHEb3H30VGf/Ky3ERnNwWJWN8RoKh72eZqgIA8MEH2BIW8itLDqsCu3YdONDQ0NUVCChKJvPX\n" +
            "vy5c6PcPDgKgi8maQsk+iDeXyDuC5YvdKNlScpmfmI9Ztz+BRJxKJgmI1tFnMgDh8NBQOg3w6qt7\n" +
            "9kQiAJFIPK4laATv884bP97rBVi8eOJEr9do7LPLoe3+Gjm21WpBuaSh7w95nEB2/WkP+HbGWXwt\n" +
            "nsdk/Dt5cnAQrf+MYQEw3T8/n6z/5gTQrgogKscIQzyOzz31VF3dhg2pFBomzZKlBEBp9myvNxJ5\n" +
            "+ulZszyeSOTqq/H18+fzQJPH4OspmbacdqJrbQSUQ5IB3mU6u57jyyQH9g1UI/FUvX+f0X0t59e2\n" +
            "QWzsY5xce59azPv1mWSA1yRF7Nhx4kQiAbB7d3MzhvaSjQDfHwx6vYoCcN11c+f6/QDBIHIYbWgv\n" +
            "q5V6kv0//KSVAfTXNKoiScBK9bOvAtr138v8/vLAIRlBMFMV6PlEAiP/jh3r79fbeDDV1KDu7/Mx\n" +
            "CdScwMgkJnu2Erz+6CNsyTvv2B1dSwmA0mOP7drV0tLYmJPjcKTTv/89NiSZ1FMgY0fZD7Swp+ub\n" +
            "WXOzGUiriSOKcDOXAPT3Zc/xbq5wOBrNZABef33fvmgUYGgIjUpsDSHWvnBhdbXHAzB//tixbjeG\n" +
            "9pq54WQ6PR/JJ98HwGgD0HNu2fMyXV7WHrmb1Ko/7bgHrSU4c5uQbF719qLu39yM1n8aL9x1AWDS\n" +
            "pGAwldJGYg5vvstwpcddMolXjz2GnJ+F+lol2xIAS6oK8Npr2IivfhU58kUXyVfBWbnnaCCIG8qs\n" +
            "/fSULLCHtU4vGRDnJms8ueXQJsDqJYKi17qNVn3x8lx6D/FgkXuPODLWgb87dpw8mUwC7NnT1oYT\n" +
            "Rs/5c3JQx7/22lmzfD62sUQ6TYREvxCbTUYx52d9Zb4USPYkGwue8LNyVpxfnz8yzmcnfkMEaLnN\n" +
            "wbweAnRbG+r+3d36Xa9zcjDyb/x4XBVLor9IghHFH9iNb9Hnb9tGuMwWzVkTAKIwDQ2rVrlcf/wj\n" +
            "NmHhQuw+n08WQaf132vzRcDmAUyqBebwhERm1DOK9mLCQIDWr8ajv7X1Uvdr/fqsTnPg89cUO/76\n" +
            "6wcOxOMAQ0NIxckYSPBevLi62u0GmD27osLp1Or8YiMfa49M9LdSCWSEQKwKaHPNVAGjpGjPVjQS\n" +
            "QmAuCVoRDLGqQNdHj6LoT1vi0ddVVPh86TTbB8Mo2VipMtlIzrTs7o9/zJbzUxqGBKAd8Ndfx8a8\n" +
            "9RYC7dprZTq9WQAOXrP7PIBpgIhji63z2Yfu0sDpJQT9V/Lr9SlQRys54F96zs3vv8/8/Hi1Y0dz\n" +
            "cyoFsHdveztyfn15su5fc8306R4Pcyuxk3pombBR5xdD2Aj8bJYDi/JFgNfKA9lyfrP7xny5V8As\n" +
            "8s9OfIHYloD10Y4/Bw/29TmdemYBADB1ajCYTAIEgxgfY+ZlsFJxzQmcqqrqW28RDmGYadgEoK5u\n" +
            "w4Z0enCwoeHSS53O3/wGu2LJEpyARUVsQBmwseHmATha7ddKtNdKBrzxTk4oeJGeuee0gykiMPRe\n" +
            "vTHQfFGP1h2HnB83SHv99UOHkkl2ViJxfmrDkiUTJrhcANOnl5biDj4U4CM38pH7VT9SfHl9n5ol\n" +
            "nsdrp6XovjlBsFIFshF5tfPDiqOaewXMCIH2OZqvZ85gzH9TE6oANMouF/7W1YVCeNoyvp+8BXJA\n" +
            "W7k3Rf3Q3Y3Xv/kN4dA+cvVpBBIAG1ZVxWWGivLkk9hR3/mOiDPzurdetGcDSZNVzMH1koEodNce\n" +
            "IaBuZcC349eXL+ph9WnhQN/PrP2trZkMwP79HR0YIabn/IWFfr+iAFx11dSpLheA201tYZyf+l4P\n" +
            "eLZxiD7JCYD12LL/xSNvRhDs2QKMnNAIeH19YiNuNoRArBqYEwyab0ePDgy43XjorXY+FRa63ZkM\n" +
            "QE2N359MigmJWPUxDzgS3Qd48kkt7kaSRkwApk17++1MJpVqaLj0UkX5zW+wgcuX47SfM8eoEjBo\n" +
            "WIn2vPGOnspOtDcSAuLc+r34jJIBAZ+3AeBfLKCHjIciWwABc2AArft//euRI+m0kfNTrcuWVVc7\n" +
            "nQBTpxYViQJ8WGw/f7CKbIGwWY55MlcJtNBn9xmQ+HL2Ob/ouZG4C0VGP7lXSSwBUMz//v19fS4X\n" +
            "gP5sZYCamkAgmQQoLna5KDReZmPQSyKygCeRyL93L+b85jeEu+xG1JhsuwGtEooidMLQz3+OHxAO\n" +
            "W0c+2fWPZh/ZJS4vW61mDDTRl7MOXBG5u4hA7NjR3o6cv7MzkzFy/pKSYFBRAK64YvJkhwPA6aSJ\n" +
            "YR2IQ98lc8/Rd4lCj42/4ufsv1ceiKQtL9p+XM+ZreqVBR7Z22FJ5J40E/0p1PfQoYEBPOUa5z2N\n" +
            "4+zZOTmJhDxAzv6aBBE+8CAPVf35zxnORieNWAIwJlWlGGRVXboUG/7tb5uJ9nrbgFG0H51QXWa9\n" +
            "Nzf26XV2o6hP9YnX7zP5Bo12g4O4SeTatceOAbB943nOf/HF48crCsDEiXl5OPxM59e/Sc/ptav9\n" +
            "2JcY7SUj5f8sx8jfZRxfe529LcAoAYiet7b+W5cTMwwsR/sqNDQMDHg8AB0dsZj2mHta5z9tWiAQ\n" +
            "j5sxKKtViGaqwhNPaHE1mmnUCQCuO47HGxouucTp/MUv8IPmzcPuWrTICFxUBYx+eZkNYLiEQG/E\n" +
            "ozJaoGM5sTUfh4gRBN69R+YgAiS1cefO06cBAA4cwNNYeM5fXh4MAgBcdtmECfgcTpRMxkhS9Gss\n" +
            "6B5PIFj6eCIB+Ss9ATACnb9jTRDMAW8l8purCFYiP/9cMomSwa5dvb1uNwv5pVRdjTp/ZaXHg35/\n" +
            "K2DLjY9GwvHhh9jPv/gF4WpkY2lMH4MEgAkb3NKChODHP8bu/POfEe4VFaLQ3Wyt+PYIgV5HN4b4\n" +
            "Mo4tswGY+fkZ8PXXg4O4OOSNN5qacH0/brLCTofFdPHF48YBAIwfHwplMmjt13sP9EY8Rhb4df5i\n" +
            "AjCai4Ht2QT05YfD+bXl5YAfPUIgFv0x/+xZDPShsy95cjt3bigUjwP4/YqSTmsDtOzZAIztUlVV\n" +
            "PX0a//rxjwlHIxlDs/SxEQCWUql0+p13ANxup/PBB/Fjf/lLFK38fhGQefF1eIRAZsSTRewZ3YLa\n" +
            "r5D59XnrP7Vx586ODqcToL6+q0sLfJp2lZXI+VetGjeOJ4Raji8CvOiaJxRGI+FIkwzYLNeeKmC8\n" +
            "rycIMms5X5+VEVBm9DNfLs5b/evr+/s9HoAzZxIJre5Pi3xmz8Yt8bJffiwyUkaj+NeDDzLcfLzp\n" +
            "YycAdXUbNwKoakPDypUAjz2GQu6UKdi9999PIB09UV8PSN7vT3eMoj57Tq8i8G5ARgr0+XhNy0Lf\n" +
            "fLO5WVHwCDUARgDo6RUrqqoyGTw8Fb+NDliR+fnFEoFW5xc/J0vDiwowlrTm+PqSRs7PlzcDfLaS\n" +
            "gRkhMFMNaNy2bevt9XiMVv/Jk/3+RAJgzBi3G3fBtj4rUb5mgUjAI4/gbH3sMcINfMzpE5AAMNXV\n" +
            "vfNOOh2LNTRcconD8eCDmDtmDHbYDTfwojl20XAIATPiiY19tDqLtwHY26XXGODDdu9VFIBduzo7\n" +
            "XS6A+vrubrTm6zn/mDHBoKoCXHLJmDHptNYZyoCr5eD8ll7Wq/3Mhf7h7QlsVkIMcG1pM6BbqQJy\n" +
            "42B2AUPWKoM+1r+5ORJxuQAaGsJh3AtT39vz5oVC0SgAnrnAzmC0ijcQGxtffpk4f13dO+9kMhTi\n" +
            "+/GnT4wAUKqre/vtTKarC20D3/sedkFJCXbUsmU84LHLzAmBzIhnvjxXvKiHTTyxiK8X0AGIbEUi\n" +
            "aN1ft6611emUc/6VKxH4Y8b4/ajzs6PV9IBnrRaL/npjoPXef0ZJwTyZl2SA4subqwKi58yNgzIO\n" +
            "L1MFsgU+uybjq6oC7NjR1+fxAPT3p1JaxlRcjCdezZrl98tEfxHwxd6J99/H7/je9wgXdkdntNIn\n" +
            "TgAooXHj5EkkBPffj5302GNoG5g/nwBPyRjCawSwmLNrtXOxW9DMqCc3Auqt/bt3d3W53QD79/f2\n" +
            "Op1Gzj92bDCYyQCsWFFeTifIa+0dWsVCBnj6X8T55Xv/jZ4XgM8XEQCm55sTBLmqIFcFCEB0JbYV\n" +
            "DC9giIx+vb3otv3oo/5+r9fYulmzAoFYDKC83OWibfDt6Px6XX/nTqzx/vsJByMbo+GnT40AUMIO\n" +
            "qK9HQnD33dhBjz2GXTZrFgOyfBGP+D4z1vGSAm/805IGK78+/3w4jBxi3bpTp9xutjqMyAb9XnJJ\n" +
            "RUUqBVBRgVtEsSguZuzTc/ZsV/tZRwKOLFkb/fR/GS0AVkAX5VupAmbAFr/HSCC0Vv+9ewcG/H6A\n" +
            "kydjMbeb9arXi+Ny/vm4Ga7LhW+wEv31hGD/fmzT3XfTvB/dMco+jVok4EgTdsiuXTgw//zP1GHy\n" +
            "DpUfKcVvRGFmhZXtV28VKUYBInv39vSgtR9Xh/FHdY0dGwhkMgDLl5eU4AJge2fsiSLctJxGFpFn\n" +
            "teGHNsJP9mv2vDwSUNxOs+fF/ZzthiK82y37cwlUFZdjAwC8/35fn9/PjH5ElsaP93gSCYDaWq83\n" +
            "FtOuzbBztNn+/TSv2Tz/bKRPXQLgExpBPvywoWHlSofja19DPv/ww9iZCxaI/Pp6CYBxfgCtpGDP\n" +
            "r89i+M2t/5EIcf6ODo8HdX5UCfQ6/yWXlJbG43h4KgaKMGu/yNjHOKYxwEfs19fnaI2EfDKPGzCK\n" +
            "+mLh31wS0F6ZqQIjMQ7qJQYrt6G57k+c/8iRSMTrBWhoiEQ8HmM/L1wYDA4NAeTlKQqdfSlmLNr3\n" +
            "7tiBOffcg/P6swN8Sp85AkCJOkxPCH77W5zgy5fzBi/johzzRT28UczMz0/WdwQ41r9vH/qH6+tx\n" +
            "dRjP+SdMwD3hli0rKsIQUeJcDMhiY58M8EYCYfzLeKXNz04pkPkDZIRCTBisCYKVcdBo5OOfNwe8\n" +
            "mFBQ+WQS8z/4oL/f7wcIh3ErfOqt4mKXK5UCOP98vx8j8u2E8KILT1Xvvx/n8YED2fT8J5k+MyqA\n" +
            "LLEOVFVVvesu7OoXXkDRjrQw0cAMb1GPKF870JEIiopvvXX2rM/HOD+Bi4x/l15aXByNApSU4AQy\n" +
            "E015EZ5vr17Uzu44b7uivZmqIBbdZe0QHxFm3A1YvLuv7H1GY5rxe/WqHZsHovF1ODD/5MmhIZcL\n" +
            "YOfOcNjv14eMAwDMmePzDQ0BjBnjcsXjetGf1Ud/vfACzdPPOvApfWYlAD5hhzY3NzSsWOFw3HMP\n" +
            "8ub2duTv3/oWAEAmEwjwfn3e+Gdt5SdOy+/eS5x/cNDrBdi/f3BQKyrSdJs0KRBIpQCWLMnPJzeR\n" +
            "PhBJ5ueXGfnExj2ZN4CSth77rj9ZTfxfxvtG6z+7bzQHav8fvnHQzG0ocwvSdTqNvxs39vcHg+zU\n" +
            "a+pN3AYf4MILA4HBQQCnk7EbVt/QENb3yCPY/gcfrKt7991Mprt7JD3+SabPDQGgRB2MhOAHPwAA\n" +
            "UNXDh1FF+MlPcFgrK2VHb8n9+lRebP0fGkLRcP367u5AwKjzM2t/YeHQEEBxMZ6gxHR+VqPY7ScO\n" +
            "8LFe7TdaIr9VslYJRATACHCxKmAEMv9eo6jPPy9zC2rL0WKrlpZ43O0G2LYtHA4E9PYRRQGoq/N6\n" +
            "o1GAqVPd7qEhHEdmFjx1Cuv76U/x+okncF5+cgE8o5U+dwSAEnV4Q8Py5QCPPILHZh45ggPz4IPI\n" +
            "8S+4gPbflUX2EXSNRkDm5wcA2L8/EvH78dfrNXL+KVMCgUQC4MILc3O1E4ZJIrwub1zMQ+X0xrJs\n" +
            "V/vxEsLoJDMOb/xLeyUzEloDXZRvbRwUu//ol4x3H3wwMBAMAnR2plK4yAefcrmQ8190kd8/MADg\n" +
            "96tqKkVy3NatWOpHP0JZ4P33P6mQ3Y8rfW4JACXtAGQyGzeiZHDzzQAAqvq97yGn+NrXcPVhTg4L\n" +
            "IGKygJk3gDj/hg29vcGgkfMznT8vLxIBKChwOCg2XK9S8CL98Ff76VUIvkeYsVA8La3IgtVk5gEt\n" +
            "+8ueKpAN0EXlrO/rQ3zb2hIJtxtg8+ZwOBRiraNYkalT3e5oFGD2bI8nHB4cpNh8rP8//xMZT3v7\n" +
            "sCbrZzB97gkAn2iADh1asUJRvv99hMmmTTi8P/iBqqpqJnPeeUwyEFv/acLU10ejyPmHhrRGIuIz\n" +
            "U6b4fPE4Oy2ZGb9oNZ4e8PguM8JASbbaj3f7GUsMD/h8yo4Q8PnGu3KOT1dmEoEZ58fyMt2f6fwA\n" +
            "AO++OzgYCgGcOpVKofcGn8adfFR1xgy3OxLZvbuoSFESiZ/9LJlUVUV5/fW6unffVVWM5Ph7Sn93\n" +
            "BIDStGlswFT1pZeQIHz0EQ74/ffjlLjrLgRoSQlvHMQjuQE2bBgYyM0FGBpCqwEtMHK5EOCXXpqT\n" +
            "MzgIkJ9P/mFzP7+Vsc96tZ885DebUGDrKACrO+YEQPS8jOPrS46WcZA4P9bQ3ByPe70AGzdGIrm5\n" +
            "LLKvstLpjMfPni0tdTqTySeeKChwOFKp3/520qR33gHAdfifXwHfOo1yuOhnPx08ePHFiuJyIVwW\n" +
            "LUJg/n//H969/HK09vv9O3fG46EQwK9/3dNTWQkQjdI+AVgST0kG+MEPyspOnwbIzcX14TI/Py/6\n" +
            "m/n7tflm19raRHdGt+fE/n8Rp9f/JQe4uFy2nN9cFaDFPc8/PzBQXAzQ0BCP+3zR6PTpHs/Q0Jtv\n" +
            "1ta63UND//f/Xn11Xl44/OGHgcDatQAj32zz85L+4QgAnw4duvhiRQkGEUhXXIFLdO+55+GHBwYq\n" +
            "Ky+44N13o9G8PDyYE4Bx/nvvLSg4cwZgxYpQCDVFsbFPJtrLRHoRgaBcGcA/nkVAfLKSEWTWf/55\n" +
            "sag/+sZBlADi8UxGUeLxQ4cSCb9/69bSUocjmXz44fnzA4FY7I038vPXrQOIREa3rz4/6R+eAPBp\n" +
            "376LL3Y48vP/8pdwuKTkyiu3b4/Hc3O/+c2OjnTa41m0CDmH1/u97xUWtrcDhEJOJ795p7lobw14\n" +
            "OyG/2UcCjlYSSwJyo5/xSszx9SXlqoLc7cfu4846ANu3Y86jj+bmOp2qunbtmDEbNgD09X28ffT5\n" +
            "SV8QAIv0wx8uXFhenp//7rvRaH7+lVfefnsodObMrbeuXBkI9PUtXow2hMJCAH2gj0gS4K/tGPns\n" +
            "rPITEwxZGqkXgEpZuf9EJdm13EgoBzxfHyvX04MEgTxCTz6JJd57b9q0995T1f5+e33zj5e+IABZ\n" +
            "piNHVq50OPx+jAibPRsBdd11CKsrr0QoTpmC+R4PgDECkK7siP7aZcF0bfxL9JxVvt0kNwKKc4ya\n" +
            "v934AJlkwPITCcw/ehTz1q7FfNqGfu/eadPeew/g8xeQ82mlLwjACNPBg8uWIUgdDoDycgAARbnw\n" +
            "QgTeZZdhqaVLEfDV1XitDSKWRwDq841X5pGAsvKiOsUwF4v24lJm5XkOLi6vJQiJBBIE2ihj0yYs\n" +
            "t24dltyyBQN+OjqmT6dddb5Iw0lfEICPKR08uHw5hgkpCkBlJQCAosybh3eXLkUILl6MQJw8GSFf\n" +
            "UID3tVHpdjcA0ZaV/TW8JObsxlJm7j/9k3hurqr29mLusWN4f9s2vI9n3qnqrl1Y66lT06dv3IjP\n" +
            "fZFGM31BAD7hdPDgRRcxiSE3F+GJkoGiTJ+Opc47D39nzMD7eHYAQGkpqgM5OZjvdmO+GW8fbSVA\n" +
            "JiuoKkAyiX/RabWdneSFp6/H39278amDB/H+yZPI0QcGpk//4IMvOPonl74gAJ+xdPAgqg+K4nbj\n" +
            "nrMAAMXFekJQUwMAwFQK+h07lpUHAMBjxhih8XrxmggH/VLCpc74i040vB4YwF8yptHmla2t+Iui\n" +
            "OhPZm5rweTrQoqtLVZNJgFhs+vQtW74A+Gcn/f/nrR8wMPI/hQAAACV0RVh0Y3JlYXRlLWRhdGUA\n" +
            "MjAxMy0wNC0xOVQwMDowMjozNi0wNTowMJui0P4AAAAldEVYdG1vZGlmeS1kYXRlADIwMTMtMDEt\n" +
            "MjJUMTI6MTc6MDctMDY6MDATYbhJAAAAAElFTkSuQmCC\n";

    private List<Interest> interests = Arrays.asList(new Interest("football", footballAva), new Interest("basketball", basketballAva),new Interest("football", footballAva), new Interest("basketball", basketballAva),new Interest("football", footballAva), new Interest("basketball", basketballAva),new Interest("football", footballAva), new Interest("basketball", basketballAva));

    private OnListFragmentInteractionListener mListener;

    public AddInterestFragment1() {

    }

    public static AddInterestFragment1 newInstance() {
        AddInterestFragment1 fragment = new AddInterestFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.add_interest_screen1, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.interest_list);
        recyclerView.setAdapter(new InterestAdapter(interests));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onInterestListFragmentInteraction();
    }
}
