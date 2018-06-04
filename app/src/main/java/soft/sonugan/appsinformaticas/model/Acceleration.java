package soft.sonugan.appsinformaticas.model;

import static android.hardware.SensorManager.GRAVITY_EARTH;

public class Acceleration {
    private float xAxis;
    private float yAxis;
    private float zAxis;

    // alpha is calculated as t / (t + dT)
    // with t, the low-pass filter's time-constant
    // and dT, the event delivery rate
    ////https://developer.android.com/reference/android/hardware/SensorEvent
    private final float alpha = 0.8f;


    public Acceleration(float xAxis, float yAxis, float zAxis){
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
        removeGravityEffect();
    }

    public float getxAxisValue(){
        return this.xAxis;
    }

    public float getyAxisValue(){
        return this.yAxis;
    }

    public float getzAxisValue(){
        return this.zAxis;
    }

    public float getRootSquare(){
        return (xAxis * xAxis + yAxis * yAxis + zAxis * zAxis) / (GRAVITY_EARTH);
    }

    private void removeGravityEffect(){
        float[] gravity = new float[3];
        gravity[0] = alpha * gravity[0] + (1 - alpha) * xAxis;
        gravity[1] = alpha * gravity[1] + (1 - alpha) * yAxis;
        gravity[2] = alpha * gravity[2] + (1 - alpha) * zAxis;

        this.xAxis = xAxis - gravity[0];
        this.yAxis = xAxis - gravity[1];
        this.zAxis = zAxis - gravity[2];
    }
}
