using UnityEngine;

public class NewMonoBehaviourScript : MonoBehaviour
{
    private float minSize= 0.3f;

    private float maxSize= 2f;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        trasnform.localScale =
        new Vector3(Random.Range (minSize, maxSize), 3, 1);
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
