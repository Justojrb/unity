using UnityEngine;
using UnityEngine.InputSystem;

public class Playercontroller : MonoBehaviour
{
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
       if (Mouse.current.leftButton.isPressed)
        {
            Debug.Log("The left botton is cliked");
            Debug.Log("The current mouse position on the screen is :" + Mouse.current.leftButton.isPressed);
            Vector3 mousePos = camera.main.ScreeToWorldPoint(Mouse.current.position.value);
            Debug.Log(" The world position of the mouse is: " + mousePos);
            Vector2 dir = mousePos - gameObject.transform.position;
            debug.Log("The direction to the mouse is: " + dir);
        }
    }
}

