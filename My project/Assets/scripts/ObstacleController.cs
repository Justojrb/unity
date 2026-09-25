using UnityEngine;

public class Obtaclecontroller : MonoBehaviour
{
    [SerializeField]
    private float minSize = 0.3f;
    [SerializeField]
    private float maxSize = 2f;
    [SerializeField]
    private float minForce = 20f;
    [SerializeField]
    private float maxForce = 48f;
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        //Asing a random size to each obstacle object
        float size = Random.Range(minSize, maxSize);
        transform.localScale = new Vector3(size, size, 1);
        // Get the rigibody compenent on uor game object
        Rigidbody2D rb = GetComponent<Rigidbody2D>();
        Transform tf = GetComponent<Transform>();
        Vector2 randomDirection = Random.insideUnitCircle;
        // Generate a random force
        float force = Random.Range(minForce, maxForce);
        rb.AddForce(Vector2.up * 34);
        Debug.Log(transform == tf);


    }

    // Update is called once per frame
    void Update()
    {
        
    }
}